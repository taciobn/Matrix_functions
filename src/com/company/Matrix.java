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

    public Matrix somaMatriz(Matrix m) {
        if (m.linhas == this.linhas && m.colunas == this.colunas) {
            Matrix m1 = new Matrix(this.linhas, this.colunas);
            for (int i = 0; i < m.linhas; i++) {
                for (int j = 0; j < m.colunas; j++) {
                    m1.matriz[i][j] = (m.matriz[i][j] + this.matriz[i][j]);
                }
            }
            return m1;
        } else {
            return null;
        }
    }

    public Matrix subtraçaoMatriz(Matrix m) {

        if (m.linhas == this.linhas && m.colunas == this.colunas) {
            Matrix m1 = new Matrix(this.linhas, this.colunas);
            for (int i = 0; i < m.linhas; i++) {
                for (int j = 0; j < m.colunas; j++) {
                    m1.matriz[i][j] = (this.matriz[i][j] - m.matriz[i][j]);
                }
            }
            return m1;
        } else {
            return null;
        }

    }

    public Matrix multMatriz(Matrix m) {
        Matrix m1 = new Matrix(this.linhas, m.colunas, 0);
        for (int i = 0; i < m1.linhas; i++) {
            for (int j = 0; j < m1.colunas; j++) {
                for (int k = 0; k < m1.colunas; k++) {
                    m1.matriz[i][j] += this.matriz[i][k] * m.matriz[j][k];

                }
            }

        }
        return m1;
    }

    public double detMatriz1() {
        double neg1 = 1, neg2 = 1, neg3 = 1;
        double pos1 = 1, pos2 = 1, pos3 = 1;
        if ((this.linhas == this.colunas) == true) {
            if (this.linhas == 2) {
                double aux = this.matriz[0][0] * this.matriz[1][1];
                double aux2 = this.matriz[0][1] * this.matriz[1][0];
                return aux - aux2;
            } else if (this.linhas == 3) {

                Matrix m = new Matrix(this.linhas, this.colunas + 2);
                for (int i = 0; i < this.linhas; i++) {
                    for (int j = 0; j < this.colunas; j++) {

                        if (j > 3) {
                            int jj=j-3;
                            m.matriz[i][j] = this.matriz[i][jj];
                        }else{
                            m.matriz[i][j] = this.matriz[i][j];
                        }
                    }
                }
                for (int i = 0; i < this.linhas - 1; i++) {
                    for (int j = 0; j < this.colunas - 1; j++) {
                        m.matriz[i][j + 3] = this.matriz[i][j];
                    }
                }
                for (int i = 0; i < m.linhas; i++) {
                    for (int j = 0; j < m.colunas; j++) {
                        switch (i + j) {
                            case 2:
                                neg1 *= this.matriz[i][j];
                                break;
                            case 3:
                                neg2 *= this.matriz[i][j];
                                break;
                            case 4:
                                neg3 *= this.matriz[i][j];
                                break;
                            default:
                                break;
                        }
                        if (i == j) {
                            pos1 *= this.matriz[i][j];
                        }
                    }
                }
                int cont = 0;
                for (int i = 0; i < this.linhas - 1; i++) {
                    switch (cont - i) {
                        case 1:
                            pos2 *= this.matriz[cont][i];
                            cont++;
                            break;
                        case 2:
                            pos3 *= this.matriz[cont][i];
                            cont++;
                        default:
                            break;
                    }

                }
            }
        }
        return (pos1 + pos2 + pos3) - (neg1 + neg2 + neg3);
    }

    public double detMatriz2() {
        Matrix matrix;
        matrix = new Matrix(this.linhas - 1, this.colunas - 1, 0);
        double det = 0;
        int contj = 0;
        double aux;
        for (int i = 0; i > this.matriz.length; i++) {
            for (int j = 0; j < this.colunas; j++) {
                if (i == 0 || j == contj) {

                } else {
                    if (j < contj) {
                        matrix.matriz[i][j] = this.matriz[(i - 1)][j];
                    } else if (j > contj) {
                        matrix.matriz[i][j] = this.matriz[(i - 1)][(j - 1)];
                    }
                }

                aux = Math.pow((-1), (i + contj));
                det += aux * (matrix.detMatriz1());

            }//acaba o for j
        }//acaba o for i
        return det;
    }
}
