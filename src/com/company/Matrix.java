package com.company;

public class Matrix {
     public double matriz[][];
    public int linhas;
    public int colunas;

    public Matrix(int linha, int coluna) {
        this.linhas = linha;
        this.colunas = coluna;
        matriz = new double[linhas][colunas];
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                matriz[i][j] = (int) (Math.random() * (50 - 1) + 1);
            }
        }
    }

    public Matrix(int linhas, int colunas, int valor) {
        this.linhas = linhas;
        this.colunas = colunas;
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                matriz[i][j] = valor;
            }
        }
    }

    public Matrix(double m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                matriz[i][j] = m[i][j];
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

    public static boolean tipoMatriz(double matriz[][]) {
        return matriz.length == matriz[0].length;
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
                System.out.println();
            }
            System.out.println();
        }
    }

    public void diagonalSecundaria() {
        System.out.println("A diagonal secundaria é: ");
        if (this.linhas == this.colunas) {
            for (int i = 0; i < this.linhas; i++) {
                for (int j = 0; j < this.colunas; j++) {
                    if ((i + j) == (matriz.length - 1)) {
                        System.out.print(matriz[i][j]);
                    }
                    System.out.print(" \t");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public double[][] somaMatriz(double m1[][], double m2[][]) {
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    matriz[i][j] = (m1[i][j] + m2[i][j]);
                }
            }
            return matriz;
        } else {
            return null;
        }
    }

    public double[][] subtraçaoMatriz(double m1[][], double m2[][]) {
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    matriz[i][j] = (m1[i][j] - m2[i][j]);
                }
            }
            return matriz;
        } else {
            return null;
        }

    }

    public double[][] multMatriz(double m1[][], double m2[][]) {
        if (m1[0].length == m2.length) {
            double aux = 0;
            int cont = 0;
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    aux = aux + (m1[i][j] * m2[j][i]);
                }
                matriz[i][cont] = aux;
                cont = cont + 1;
                if (cont >= m2.length) {
                    cont = 0;
                }
            }
            return matriz;
            
        } else {
            return null;
        }

    }
}
