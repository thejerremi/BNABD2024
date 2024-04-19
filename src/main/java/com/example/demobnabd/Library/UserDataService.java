package com.example.demobnabd.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private final UserDataRepository UserDataRepository;


    public UserDataService(UserDataRepository UserDataRepository) {
        this.UserDataRepository = UserDataRepository;
    }

    public Optional<UserData> findById(Long id){
        return UserDataRepository.findById(id);
    }
    public List<UserData> findAll(){
        return UserDataRepository.findAll();
    }
    public UserData save(UserData UserData){
        return UserDataRepository.save(UserData);
    }
    public List<UserData> saveAll(List<UserData> UserDatas){
        return UserDataRepository.saveAll(UserDatas);
    }

    public void deleteById(Long id){
        UserDataRepository.deleteById(id);
    }
}
