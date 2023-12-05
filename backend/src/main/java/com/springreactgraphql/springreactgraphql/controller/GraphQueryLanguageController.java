package com.springreactgraphql.springreactgraphql.controller;

import com.springreactgraphql.springreactgraphql.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="/graphql") // This means URL's start with /graphql (after Application path)
public class GraphQueryLanguageController {

    @Autowired // This means to get the bean called graphQLService
    // Which is auto-generated by Spring, we will use it to handle the data
    private GraphQLService graphQLService;

    @PostMapping("/query") // Map ONLY POST Requests
    public ResponseEntity<Object> getQuery(@RequestBody String query){
        ExecutionResult execute = graphQLService.executeGraphQL(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

}

