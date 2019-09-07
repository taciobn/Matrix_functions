package com.company;

public class Matrix {
     public int matriz[][];
    public int linhas;
    public int colunas;

    public Matriz(int linha, int coluna) {
        this.linhas = linha;
        this.colunas = coluna;
        matriz = new int[linhas][colunas];
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                matriz[i][j] = (int) (Math.random() * (50 - 1) + 1);
            }
        }
    }

    public void imprimirMatriz() {
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void tipoMatriz() {
        if (this.linhas == 1) {
            System.out.println("Matriz Linha");
        } else if (this.colunas == 1) {
            System.out.println("Matriz Coluna");
        } else if (this.linhas == this.colunas) {
            System.out.println("Matriz Quadrada de ordem " + this.linhas);
        } else {
            System.out.println("Matriz nao é especial");
        }
    }

    public void diagonalPrincipal() {
        if (this.colunas == this.linhas) {
            System.out.println("A diaginal principal é: ");
            for (int i = 0; i < this.linhas; i++) {
                for (int j = 0; j < this.colunas; j++) {
                    if (i == j) {
                        System.out.print(matriz[i][j]);
                    }
                    System.out.print("\t");
                }
                System.out.println( );
            }
            System.out.println();
        }
    }

    public void diagonalSecundaria() {
        System.out.println("A diagonal secundaria é: ");
        if(this.linhas==this.colunas){
            for (int i = 0; i < this.linhas; i++) {
                for (int j = 0; j < this.colunas; j++) {
                    if ((i+j)==(matriz.length-1)) {
                        System.out.print(matriz[i][j]);
                    }
                    System.out.print(" \t");
                }
                System.out.println();
            }
            System.out.println( );
        }

    }
}
