package ru.aahzbrut.reciperestapi.unit.entities.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public abstract class TestUtils {

    // Check that all Collections properties have default values (NPE defence)
    @Test
    static void npeDefence(Class<? extends BaseEntity> clazz) {

        Class<?> collectionType = java.util.Collection.class;

        Object objectUnderTest;
        try {
            objectUnderTest = clazz.getConstructor().newInstance();
        } catch (Exception ex) {
            log.error("Error trying to create instance of " + clazz.getName(), ex);
            throw new RuntimeException("Error trying to create instance of " + clazz.getName(), ex);
        }

        Stream.of(clazz.getDeclaredFields())
                .filter(field -> collectionType.isAssignableFrom(field.getType()))
                .forEach(field -> {
                    String getterName = "get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
                    try {
                        Method method = clazz.getDeclaredMethod(getterName);
                        assertNotNull(method.invoke(objectUnderTest), "Field " + clazz.getSimpleName() + "." + field.getName() + " must be initialized and annotated with @Builder.default");
                    } catch (Exception ex) {
                        log.error("Can't find or execute method: " + getterName, ex);
                        throw new RuntimeException("Can't find or execute method: " + getterName, ex);
                    }
                });
    }
}
