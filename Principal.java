/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.principal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amanda Cardoso
 */
public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Empregado> empregados = new ArrayList<>();
            boolean running = true;
            
            while (running) {
                System.out.println("Menu:");
                System.out.println("1. Criar novo empregado");
                System.out.println("2. Promover empregado");
                System.out.println("3. Aumentar salario do empregado");
                System.out.println("4. Demitir empregado");
                System.out.println("5. Fazer aniversário do empregado");
                System.out.println("6. Mostrar detalhes dos empregados");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = scanner.next();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        System.out.print("Salario: ");
                        double salario = scanner.nextDouble();
                        empregados.add(new Empregado(nome, idade, salario));
                    }
                    case 2 -> {
                        System.out.print("Indice do empregado para promover: ");
                        int indicePromover = scanner.nextInt();
                        if (indicePromover >= 0 && indicePromover < empregados.size()) {
                            empregados.get(indicePromover).promover();
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Índice do empregado para aumentar salário: ");
                        int indiceAumentar = scanner.nextInt();
                        if (indiceAumentar >= 0 && indiceAumentar < empregados.size()) {
                            System.out.print("Percentual de aumento: ");
                            double percentual = scanner.nextDouble();
                            empregados.get(indiceAumentar).aumentarSalario(percentual);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Índice do empregado para demitir: ");
                        int indiceDemitir = scanner.nextInt();
                        if (indiceDemitir >= 0 && indiceDemitir < empregados.size()) {
                            System.out.print("Motivo (1: Justa causa, 2: Decisão do empregador, 3: Aposentadoria): ");
                            int motivo = scanner.nextInt();
                            empregados.get(indiceDemitir).demitir(motivo);
                            empregados.remove(indiceDemitir);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Índice do empregado para fazer aniversario: ");
                        int indiceAniversario = scanner.nextInt();
                        if (indiceAniversario >= 0 && indiceAniversario < empregados.size()) {
                            empregados.get(indiceAniversario).fazerAniversario();
                        } else {
                            System.out.println("Indice invalido.");
                        }
                    }
                    case 6 -> {
                        for (int i = 0; i < empregados.size(); i++) {
                            System.out.println("Índice " + i + ": " + empregados.get(i));
                        }
                    }
                    case 7 -> running = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}
