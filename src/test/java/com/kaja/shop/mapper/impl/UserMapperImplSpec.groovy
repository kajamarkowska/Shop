package com.kaja.shop.mapper.impl

import com.kaja.shop.domain.dao.User
import com.kaja.shop.domain.dto.UserDto
import spock.lang.Specification

class UserMapperImplSpec extends Specification {
    def "test userDto to user"() {
        given:
        def userMapperImpl = new UserMapperImpl()
        def userDto = UserDto.builder()
                .email("email")
                .id(1)
                .password("abc")
                .version(1)
                .build()

        when:
        def result = userMapperImpl.userDtoToUser(userDto)

        then:
        result.email == userDto.email
        result.id == userDto.id
        result.password == userDto.password
        result.version == userDto.version

    }

    def "test user to userDto"() {
        given:
        def userMapperImpl = new UserMapperImpl()
        def user = User.builder()
                .email("abc@test")
                .id(2)
                .password("abc")
                .version(1)
                .build()
        when:
        def testResult = userMapperImpl.userToUserDto(user);

        then:
        testResult.email == user.email
        testResult.id == user.id
        testResult.password == null
        testResult.version == user.version
    }
}
