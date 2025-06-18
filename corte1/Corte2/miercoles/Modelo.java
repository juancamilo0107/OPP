import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Modelo {

    public List<String> resolverPolinomio(int grado, double[] coeficientes) {
        List<String> resultados = new ArrayList<>();

        switch (grado) {
            case 1:
                resultados.add(resolverGrado1(coeficientes));
                break;
            case 2:
                resultados.addAll(resolverGrado2(coeficientes));
                break;
            case 3:
                resultados.addAll(resolverGrado3(coeficientes));
                break;
            case 4:
                resultados.addAll(resolverGrado4(coeficientes));
                break;
            default:
                resultados.add("Grado no válido.");
        }

        guardarResultado(grado, coeficientes, resultados);
        return resultados;
    }

    private String resolverGrado1(double[] c) {
        if (c[0] == 0) return "No es una ecuación válida (a = 0)";
        double x = -c[1] / c[0];
        return "Solución: x = " + x;
    }

    private List<String> resolverGrado2(double[] c) {
        List<String> res = new ArrayList<>();
        double a = c[0], b = c[1], d = c[2];
        double discriminante = b * b - 4 * a * d;

        if (a == 0) {
            res.add("No es una ecuación cuadrática válida.");
        } else if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            res.add("Dos soluciones reales:");
            res.add("x1 = " + x1);
            res.add("x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            res.add("Una solución real doble:");
            res.add("x = " + x);
        } else {
            double parteReal = -b / (2 * a);
            double parteImag = Math.sqrt(-discriminante) / (2 * a);
            res.add("Dos soluciones complejas:");
            res.add("x1 = " + parteReal + " + " + parteImag + "i");
            res.add("x2 = " + parteReal + " - " + parteImag + "i");
        }
        return res;
    }

    private List<String> resolverGrado3(double[] c) {
        List<String> res = new ArrayList<>();
        double a = c[0], b = c[1], d = c[2], e = c[3];

        if (a == 0) {
            res.add("No es una ecuación cúbica válida (a=0)");
            return res;
        }

        double p = (3 * a * d - b * b) / (3 * a * a);
        double q = (2 * b * b * b - 9 * a * b * d + 27 * a * a * e) / (27 * a * a * a);
        double discriminante = Math.pow(q / 2, 2) + Math.pow(p / 3, 3);
        double offset = -b / (3 * a);

        if (discriminante > 0) {
            double u = Math.cbrt(-q / 2 + Math.sqrt(discriminante));
            double v = Math.cbrt(-q / 2 - Math.sqrt(discriminante));
            double x1 = u + v + offset;
            res.add("Una raíz real:");
            res.add("x = " + x1);
        } else if (discriminante == 0) {
            double u = Math.cbrt(-q / 2);
            res.add("Raíces reales:");
            res.add("x1 = " + (2 * u + offset));
            res.add("x2 = x3 = " + (-u + offset));
        } else {
            double r = Math.sqrt(-Math.pow(p, 3) / 27);
            double phi = Math.acos(-q / (2 * Math.sqrt(-Math.pow(p, 3) / 27)));
            double t = 2 * Math.sqrt(-p / 3);

            double x1 = t * Math.cos(phi / 3) + offset;
            double x2 = t * Math.cos((phi + 2 * Math.PI) / 3) + offset;
            double x3 = t * Math.cos((phi + 4 * Math.PI) / 3) + offset;

            res.add("Tres raíces reales:");
            res.add("x1 = " + x1);
            res.add("x2 = " + x2);
            res.add("x3 = " + x3);
        }

        return res;
    }

    private List<String> resolverGrado4(double[] c) {
        List<String> res = new ArrayList<>();
        double a = c[0], b = c[1], d = c[2], e = c[3], f = c[4];

        if (a == 0) {
            res.add("No es una ecuación de cuarto grado válida.");
            return res;
        }

        if (b == 0 && d == 0) {
            // Ecuación bicuadrática: ax^4 + cx^2 + e = 0
            double discriminante = d * d - 4 * a * f;

            if (discriminante < 0) {
                res.add("No tiene raíces reales.");
            } else {
                double y1 = (-d + Math.sqrt(discriminante)) / (2 * a);
                double y2 = (-d - Math.sqrt(discriminante)) / (2 * a);

                for (double y : new double[]{y1, y2}) {
                    if (y >= 0) {
                        res.add("x = " + Math.sqrt(y));
                        res.add("x = " + (-Math.sqrt(y)));
                    } else {
                        res.add("x = sqrt(" + y + ") (raíz compleja)");
                    }
                }
            }
        } else {
            res.add("Resolución completa para grado 4 no implementada. Solo se resuelven ecuaciones bicuadráticas.");
        }

        return res;
    }

    private void guardarResultado(int grado, double[] coeficientes, List<String> resultados) {
        try (FileWriter fw = new FileWriter("resultados.txt", true)) {
            fw.write("Grado: " + grado + "\n");
            fw.write("Coeficientes: ");
            for (double c : coeficientes) {
                fw.write(c + " ");
            }
            fw.write("\nResultados:\n");
            for (String r : resultados) {
                fw.write(r + "\n");
            }
            fw.write("--------\n");
        } catch (IOException e) {
            System.out.println("Error al guardar resultados: " + e.getMessage());
        }
    }
}
