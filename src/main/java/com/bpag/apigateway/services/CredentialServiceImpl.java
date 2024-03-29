package com.bpag.apigateway.services;

import com.bpag.apigateway.persistances.entities.Credential;
import com.bpag.apigateway.persistances.repositories.ICredentialRepository;
import com.bpag.apigateway.services.interfaces.ICredentialService;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements ICredentialService {

    @Autowired
    private ICredentialRepository repository;

    @Override
    public Credential getToken(String username) {
        //Credential credential = repository.findAll().stream().findFirst().orElseThrow(RuntimeException::new);
        Credential credential1 = repository.findByCredentialEmail(username).orElseThrow(RuntimeException::new);
        return credential1;
    }

    @Override
    public BaseResponse walletLocal(String email) {
        return null;
    }

    /*@Override
    public Credential getToken2() {
        //Credential credential = repository.findAll().stream().findFirst().orElseThrow(RuntimeException::new);
        Credential credential1 = repository.findByCredentialEmail(username).orElseThrow(RuntimeException::new);

        return credential1;
    }*/

}