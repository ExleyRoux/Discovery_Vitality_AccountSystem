package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.service.GeneralResponse;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/ping")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<String>> ping(@RequestParam(value = "echo", defaultValue = "pong") String echo){
                GeneralResponse<String> response = new GeneralResponse<>(echo);
                return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping("")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<String>> getPing(@RequestParam(value = "echo", defaultValue = "pong") String echo){
        GeneralResponse<String> response = new GeneralResponse<>(echo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



//    @PostMapping("/ping")
//    @ApiOperation(value = "Creates a new Pong", notes = "Creates new Pong in the System")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "The Ping was received and echoed", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<Pong>> postPing(@ApiParam(value = "Request body to make a new Pong.", required = true) @RequestBody Pong pong){
//        GeneralResponse<Pong> response = new GeneralResponse<Pong>(pong);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @GetMapping("/error")
    @ApiOperation(value = "Throws an eception")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<String>> ping(){
        throw new RuntimeException("Give an error");
    }
}
