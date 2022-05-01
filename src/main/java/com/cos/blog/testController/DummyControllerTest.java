package com.cos.blog.testController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();

    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id" + id);
            }
        });
        return user;
    }


    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("username"+user.getUsername());
        System.out.println("password"+user.getPassword());
        System.out.println("email"+user.getEmail());
        System.out.println("role"+user.getRole());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/dummy/user")
    public Page<User> pageList(@PageableDefault( size = 2, sort = "id", direction = Sort.Direction.DESC)    Pageable pageable){
        Page<User> pagingUsers= userRepository.findAll(pageable);

        List<User> users = pagingUsers.getContent();

        return  pagingUsers;
    }

    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        System.out.println("id"+ id);
        System.out.println("password"+ requestUser.getPassword());
        System.out.println("email"+ requestUser.getEmail());

        //아이디 찾기
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다");
        });
        System.out.println(user);
        //객체넣어주뭄
        user.setPassword(requestUser.getPassword());
        user.setUsername(requestUser.getEmail());

        userRepository.save(user);
        return null;
    }





}
