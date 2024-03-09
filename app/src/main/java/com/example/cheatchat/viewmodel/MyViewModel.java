package com.example.cheatchat.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.cheatchat.Repository.Repository;
import com.example.cheatchat.model.ChatGroup;
import com.example.cheatchat.model.ChatMessage;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    Repository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    //Auth
    public void signUpAnonymously(){
        Context c = this.getApplication();
        repository.firebaseAnonymous(c);
    }

    public String getCurrentUserId(){
        return repository.getCurrentUserId();
    }

    public void signOut(){
        repository.signOut();
    }

    //getting char group
    public MutableLiveData<List<ChatGroup>> getGroupList(){
        return repository.getChatGroupMutableLiveData();

    }

    public void createNewGroup(String groupName){
        repository.createNewGroup(groupName);
    }

    public MutableLiveData<List<ChatMessage>> getMessagesLiveData(String groupName){
        return repository.getMessagesLiveData(groupName);

    }

    public void sendMessage(String msg, String chatGroup){
        repository.sendMessage(msg, chatGroup);
    }

}






















