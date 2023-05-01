## Common mistakes (jv-spring-rest-web-practice)

* Don't make mistakes mentioned in previous [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-spring/rest/jv-spring-rest_checklist).
* Be attentive with ShoppingCartController. We should use PUT HTTP, not POST when adding a movie session.
* Don't create redundant dtos and mappers for them.
* What do we need to use in AuthenticationController to create User: UserService or AuthenticationService?
* Be careful which mapping should be class-level and which method-level:
    - Wrong:
    ```java
            @RestController
            @RequestMapping("/register")
            public class AuthenticationController {     
                private final AuthenticationService service;
                
                @PostMapping
                public void register(@RequestBody UserRequestDto requestDto) {
                    service.register(requestDto.getEmail(), requestDto.getPassword());
                }
            }
    ```
    - Good:
    ```java
            @RestController
            public class AuthenticationController {     
                private final AuthenticationService service;
                        
                @PostMapping("/register")
                public void register(@RequestBody UserRequestDto requestDto) {
                    service.register(requestDto.getEmail(), requestDto.getPassword());
                }
                /*
                  We may have method with @PostMapping("/login") too. 
                  So it's incorrect to add /register as class-level mapping.
                */
            }
      ```

* You can return information about tickets in your ShoppingCartResponseDto / OrderResponseDto in the form of `List<Long> ticketIds`.
* When choosing the fields to be returned in your ShoppingCartResponseDto, keep in mind that `cartId` and `userId` hold the same value.
* Don't expose secure data in your ResponseDtos.
* Follow Dependency Inversion Principle. Use `DtoRequestMapper` and `DtoResponseMapper` as types when you declare mapper fields in controllers.
