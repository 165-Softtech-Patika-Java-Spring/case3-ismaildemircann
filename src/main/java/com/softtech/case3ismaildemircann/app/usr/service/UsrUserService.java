package com.softtech.case3ismaildemircann.app.usr.service;

import com.softtech.case3ismaildemircann.app.cmt.service.entityservice.CmtCommentEntityService;
import com.softtech.case3ismaildemircann.app.gen.exceptions.GenBusinessException;
import com.softtech.case3ismaildemircann.app.gen.exceptions.ItemNotFoundException;
import com.softtech.case3ismaildemircann.app.usr.converter.UsrUserMapper;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserDeleteRequestDto;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserResponseDto;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserSaveRequestDto;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserUpdateRequestDto;
import com.softtech.case3ismaildemircann.app.usr.entity.UsrUser;
import com.softtech.case3ismaildemircann.app.usr.enums.UsrErrorMessage;
import com.softtech.case3ismaildemircann.app.usr.enums.UsrUserType;
import com.softtech.case3ismaildemircann.app.usr.service.entityservice.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;
    private final CmtCommentEntityService cmtCommentEntityService;

    public UsrUserResponseDto saveUser(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        String username = usrUserSaveRequestDto.getUsername();
        String email = usrUserSaveRequestDto.getEmail();
        Long phoneNumber = usrUserSaveRequestDto.getPhoneNumber();
        UsrUserType userType = usrUserSaveRequestDto.getUserType();

        if(usrUserEntityService.existsByUsername(username)) {
            throw new GenBusinessException(UsrErrorMessage.USER_USERNAME_EXIST_MESSAGE);
        }
        else if(usrUserEntityService.existsByEmail(email)) {
            throw new GenBusinessException(UsrErrorMessage.USER_EMAIL_EXIST_MESSAGE);
        }
        else if(usrUserEntityService.existsByPhoneNumber(phoneNumber)) {
            throw new GenBusinessException(UsrErrorMessage.USER_PHONE_NUMBER_EXIST_MESSAGE);
        }

        UsrUser usrUser = new UsrUser();
        usrUser.setUsername(username);
        usrUser.setEmail(email);
        usrUser.setPhoneNumber(phoneNumber);
        usrUser.setUserType(userType);
        usrUser = usrUserEntityService.save(usrUser);

        UsrUserResponseDto usrUserResponseDto = UsrUserMapper.INSTANCE.convertToUsrUserResponseDto(usrUser);;

        return usrUserResponseDto;

    }

    public List<UsrUserResponseDto> findAll() {

        List<UsrUser> usrUserList = usrUserEntityService.findAll();

        if(usrUserList == null) {
            throw new GenBusinessException(UsrErrorMessage.USER_NOT_FOUND_MESSAGE);
        }

        List<UsrUserResponseDto> usrUserResponseDtoList = UsrUserMapper.INSTANCE.convertToUsrUserResponseDtoList(usrUserList);

        return  usrUserResponseDtoList;

    }

    public UsrUserResponseDto findById(Long userId) {

        UsrUser usrUser = usrUserEntityService.getByIdWithControl(userId);

        if(usrUser == null) {
            throw new GenBusinessException(UsrErrorMessage.USER_NOT_FOUND_MESSAGE);
        }

        UsrUserResponseDto usrUserResponseDto = UsrUserMapper.INSTANCE.convertToUsrUserResponseDto(usrUser);

        return usrUserResponseDto;

    }

    public UsrUserResponseDto findUserByUsername(String username) {

        UsrUser usrUser = usrUserEntityService.findByUsername(username);

        if(usrUser == null) {
            throw new GenBusinessException(UsrErrorMessage.USER_NOT_FOUND_MESSAGE);
        }

        UsrUserResponseDto usrUserResponseDto = UsrUserMapper.INSTANCE.convertToUsrUserResponseDto(usrUser);

        return usrUserResponseDto;

    }

    /**
    * This method update user infos. If username, email, phone number or user type are equal the olds,
    * related attribute is not change. If different, it uses the new one.
    * @return It returns updated object
    */
    public UsrUserResponseDto updateUser(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {

        Long userId = usrUserUpdateRequestDto.getId();

        UsrUser usrUser = usrUserEntityService.getByIdWithControl(userId);

        String newUsername = usrUserUpdateRequestDto.getUsername();
        String newEmail = usrUserUpdateRequestDto.getEmail();
        Long newPhoneNumber = usrUserUpdateRequestDto.getPhoneNumber();
        UsrUserType newUserType = usrUserUpdateRequestDto.getUserType();

        if(usrUser == null) {
            throw new GenBusinessException(UsrErrorMessage.USER_NOT_FOUND_MESSAGE);
        }
        if(!newUsername.equals(usrUser.getUsername())) {
            if(usrUserEntityService.existsByUsername(newUsername)) {
                throw new GenBusinessException(UsrErrorMessage.USER_USERNAME_EXIST_MESSAGE);
            }
            usrUser.setUsername(newUsername);
        }
        if(!newEmail.equals(usrUser.getEmail())) {
            if(usrUserEntityService.existsByEmail(newEmail)) {
                throw new GenBusinessException(UsrErrorMessage.USER_EMAIL_EXIST_MESSAGE);
            }
            usrUser.setEmail(newEmail);
        }
        if(!newPhoneNumber.equals(usrUser.getPhoneNumber())) {
            if(usrUserEntityService.existsByPhoneNumber(newPhoneNumber)) {
                throw new GenBusinessException(UsrErrorMessage.USER_PHONE_NUMBER_EXIST_MESSAGE);
            }
            usrUser.setPhoneNumber(newPhoneNumber);
        }
        if(!newUserType.equals(usrUser.getUserType())) {
            usrUser.setUserType(newUserType);
        }

        usrUser = usrUserEntityService.save(usrUser);

        UsrUserResponseDto usrUserResponseDto = UsrUserMapper.INSTANCE.convertToUsrUserResponseDto(usrUser);;

        return usrUserResponseDto;

    }

    @Transactional
    public void delete(UsrUserDeleteRequestDto usrUserDeleteRequestDto) {

        String username = usrUserDeleteRequestDto.getUsername();
        Long phoneNumber = usrUserDeleteRequestDto.getPhoneNumber();

        UsrUser usrUser = usrUserEntityService.findByUsernameAndPhoneNumber(username, phoneNumber);

        if(usrUser == null) {
            throw new ItemNotFoundException(username + " username and " + phoneNumber + " phone information don't match.");
        }

        cmtCommentEntityService.deleteAllByUserId(usrUser.getId());

        usrUserEntityService.delete(usrUser);

    }

    public Boolean isExistByUserId(Long userId) {

        return usrUserEntityService.existsById(userId);
    }
}
