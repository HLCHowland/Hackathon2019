/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
import com.google.api.services.actions_fulfillment.v2.model.User;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements all intent handlers for this Action. Note that your App must extend from DialogflowApp
 * if using Dialogflow or ActionsSdkApp for ActionsSDK based Actions.
 */
public class MyActionsApp extends DialogflowApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyActionsApp.class);
  private MockData md = new MockData();
  private int i = 0;
  @ForIntent("Test Intent")
  public ActionResponse Test(ActionRequest request) {
    ResponseBuilder responseBuilder = getResponseBuilder(request);
    String test = (String) request.getParameter("test" );

    Integer number = test.length() * 123;

    String prompt = "You're lucky number is " + number + " !";

    responseBuilder.add(prompt).endConversation();
    return responseBuilder.build();
  }

  @ForIntent("QuizPrompt")
  public ActionResponse TestQuiz(ActionRequest request){

      ResponseBuilder responseBuilder = getResponseBuilder(request);
      String firstQuestionPrompt = "Okay the next question is: "+md.data[i][0];
      responseBuilder.add(firstQuestionPrompt);
      return responseBuilder.build();
  }

  @ForIntent("AnswerPrompt")
  public ActionResponse AnswerAttempt(ActionRequest request){
      ResponseBuilder responseBuilder = getResponseBuilder(request);
      String attempt = (String) request.getParameter("answerAttempt");
      if(attempt.toLowerCase().equals(md.data[i][1].toLowerCase())){
          responseBuilder.add("Correct");
          i++;
      }else{
          responseBuilder.add("Fuck you");
      }
      if(i == 5){
          i = 0;
      }
      return responseBuilder.build();
  }








}
