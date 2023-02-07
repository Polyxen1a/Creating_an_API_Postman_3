package com.skypro.creating_an_api_postman_3.controller;


import com.skypro.creating_an_api_postman_3.model.Ingredient;
import com.skypro.creating_an_api_postman_3.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
@Tag(name = "Ингредиенты", description = "CRUD- операции для работы с ингредиентами")


public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("/{id}")
    @Operation(
            description = "Поиск ингредиента по id")
    @ApiResponse(
            responseCode = "200", description = "Ингредиент найден", content = {
                    @Content(mediaType = "aplication/json", shema = @Shema(implementation = Ingredient.class))
    }
    )})
        @Parameters(value = {@Parameter(name = "id", example = "1")})
ResponseEntity<Ingredient> getIngredient(@PathVariable Integer id){
Ingredient ingredient = ingredientsService.getIngredient(id);
return ResponsEntity.ok(ingredient);

        }
        @Operation(summary = "Добавление ингредиента")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Ингредиент добавлен",
                content = {
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Ingredient.class)
                        )
                }
        )
})
@PostMapping
ResponseEntity<Ingredient> addIngredient(@Valid @RequestBody Ingredient ingredient){
        }
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
        }
        @GetMapping
@Operation(summary = "Получение всех ингредиентов")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Ингредиаенты получены",
                content = {
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Ingredient.class)
                        )
                }
        )
})
public Collection<Ingredient> getAll(){
        return this.ingredientService.getAll();
        }
        @PutMapping("/{id}")
@Operation(summary = "Изменение игредиентов по id")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Ингредиаенты изменен",
                content = {
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Ingredient.class)
                        )
                }
        )
})
@Parameters(value = {@Parameter(name = "id", example = "1")})
ResponseEntity<Ingredient> undateIngredient(@PathVariable Integer id, @Valid @Request Ingredient ingredient) {
        return ResponseEntity.ok(ingredientService.updateIngredient(id, ingredient));
        }
        @DeleteMapping("/{id}")
@Operation(summary = "Удаление ингредиентов по id")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Ингредиент удален"
        )
})
        @Parameters(value = {@Parameter(name = "id", example = "1")})
ResponseEntity<Ingredient> removeIngredient(@PathVariable Integer id) {
        return ResponseEntity.ok(ingredientService.removeIngredient(id));
}
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> hadleValidationExceptions(
        MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = ((FieldError) error).getDefaultMessage();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);
        });
    return errors;
        })