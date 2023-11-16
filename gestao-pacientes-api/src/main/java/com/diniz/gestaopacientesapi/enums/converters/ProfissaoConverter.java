package com.diniz.gestaopacientesapi.enums.converters;

import java.util.stream.Stream;

import com.diniz.gestaopacientesapi.enums.Profissao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProfissaoConverter implements AttributeConverter<Profissao, String> {

    @Override
    public String convertToDatabaseColumn(Profissao profissao) {
        if (profissao == null) {
            return null;
        }
        return profissao.getValue();
    }

    @Override
    public Profissao convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Profissao.values())
                                  .filter(p -> p.getValue()
                                  .equals(value)).findFirst().orElseThrow(IllegalArgumentException::new);
    }


}
