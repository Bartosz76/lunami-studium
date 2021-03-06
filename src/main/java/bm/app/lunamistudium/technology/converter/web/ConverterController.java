package bm.app.lunamistudium.technology.converter.web;

import bm.app.lunamistudium.technology.converter.application.port.ConverterUseCase;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequestMapping("/api/converter")
@RestController
@AllArgsConstructor
public class ConverterController {

    private final ConverterUseCase converterUseCase;

    @GetMapping
    public String testGet() {
        return "Hello there.";
    }

    @PostMapping("/decToBin/{decimal}")
    @ApiOperation(value = "Converts a decimal number into a binary one.", notes = "Provide a decimal number.")
    public String getDecimalToBinary(@PathVariable String decimal) {
        return converterUseCase.convertDecimalToBinary(decimal);
    }

    @PostMapping("/binToDec/{binary}")
    @ApiOperation(value = "Converts a binary number into a decimal one.", notes = "Provide a binary number.")
    public String getBinaryToDecimal(@PathVariable String binary) {
        return converterUseCase.convertBinaryToDecimal(binary);
    }

    @PostMapping("/binToHex/{binary}")
    @ApiOperation(value = "Converts a binary number into a hexadecimal one.", notes = "Provide a binary number.")
    public String getBinaryToHexadecimal(@PathVariable String binary) {
        return converterUseCase.convertBinaryToHexadecimal(binary);
    }

    @PostMapping("/hexToBin/{hexadecimal}")
    @ApiOperation(value = "Converts a hexadecimal number into a binary one.", notes = "Provide a hexadecimal number.")
    public String getConvertHexadecimalToBinary(@PathVariable String hexadecimal) {
        return converterUseCase.convertHexadecimalToBinary(hexadecimal);
    }
}
