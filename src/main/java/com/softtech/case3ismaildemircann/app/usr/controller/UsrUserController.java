package com.softtech.case3ismaildemircann.app.usr.controller;

import com.softtech.case3ismaildemircann.app.gen.dto.RestResponse;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserDeleteRequestDto;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserResponseDto;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserSaveRequestDto;
import com.softtech.case3ismaildemircann.app.usr.dto.UsrUserUpdateRequestDto;
import com.softtech.case3ismaildemircann.app.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsrUserController {

    private final UsrUserService usrUserService;

    @PostMapping
    @Validated
    public ResponseEntity saveUser(@RequestBody @Valid UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUserResponseDto usrUserResponseDto = usrUserService.saveUser(usrUserSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserResponseDto));

    }

    @GetMapping
    public ResponseEntity findAllUsers() {

        List<UsrUserResponseDto> usrUserResponseDtoList = usrUserService.findAll();

        return ResponseEntity.ok(RestResponse.of(usrUserResponseDtoList));

    }

    @GetMapping("/id/{userId}")
    public ResponseEntity findUserById(@PathVariable Long userId) {

        UsrUserResponseDto usrUserResponseDto = usrUserService.findById(userId);

        return ResponseEntity.ok(RestResponse.of(usrUserResponseDto));

    }

    @GetMapping("/username/{username}")
    public ResponseEntity findUserByUsername(@PathVariable String username) {

        UsrUserResponseDto usrUserResponseDto = usrUserService.findUserByUsername(username);

        return ResponseEntity.ok(RestResponse.of(usrUserResponseDto));

    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody UsrUserDeleteRequestDto usrUserDeleteRequestDto) {

        usrUserService.delete(usrUserDeleteRequestDto);

        return ResponseEntity.ok(RestResponse.of(Void.TYPE));

    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UsrUserUpdateRequestDto usrUserUpdateRequestDto) {

        UsrUserResponseDto usrUserResponseDto = usrUserService.updateUser(usrUserUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserResponseDto));

    }
}
