package com.github.integrador.conversor.utils;

public class DecodeErrors {

    private DecodeErrors() {
        throw new IllegalStateException("Classe para utils");
    }

    public static String decodeError(Integer codeError) {

        return switch (codeError) {
            case 1010 -> "Erro de inicialização do driver de conexão MYSQL.";
            case 1020 -> "Erro de inicialização do driver de conexão ORACLE.";
            default -> "Erro não identificado no retorno da consulta do médico no CFM.";
        };
    }
}
