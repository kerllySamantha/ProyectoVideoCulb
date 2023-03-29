import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Socio> socios = new ArrayList<>();
        ArrayList <Multimedia> multimedia = new ArrayList<>();
        socios.add(new Socio("12345", "Noah", "01/08/1996", "Elche"));
        socios.add(new Socio("54321", "Alex", "25/02/89", "Alicante"));
        socios.add(new Socio("112233", "Raquel", "19/02/74", "Alicante"));
        multimedia.add(new Pelicula("Licorice Pizza", "Paul Thomas Anderson", Formato.DVD, 2021, 134, "Cooper Hoffman", "Alana Haim"));
        multimedia.add(new Pelicula("Moulin Rouge", "Baz Luhrmann", Formato.BLURAY, 2001, 127, "Ewan McGregor", "Nicole Kidman"));
        multimedia.add(new Pelicula("Mujercitas", "Greta Gerwig", Formato.ARCHIVO, 2019, 134, "Timothée Chalamet", "Saoirse Ronan"));
        multimedia.add(new Videojuego("The Last Of Us", "Naughty Dog", Formato.BLURAY, 2013, "PlayStation"));
        multimedia.add(new Videojuego("Animal Crossing :D", "Nintendo", Formato.ARCHIVO, 2021, "Nintendo Switch"));
        multimedia.add(new Videojuego("Life is Strange", "Square Enix", Formato.CD, 2015, "PC"));
        int op;
        do {
            System.out.println("""
                    -------------------------------
                    1. Alquilar multimedia a socio.
                    2. Devolver multimedia
                    3. Pagar recargos
                    4. Listados ...
                    -------------------------------
                    0. Salir""");
            op=sc.nextInt();
            switch (op) {
                case 1 -> alquilarMultSocio(multimedia, socios);
                case 2 -> devolverMult(multimedia, socios);
                case 3 -> System.out.println(pagarRecargo(socios));
                case 4 -> listados(multimedia, socios);
                case 0 -> System.out.println("Has salido del programa");
            }
        }while(op != 0);
    }

    public static void alquilarMultSocio(ArrayList<Multimedia>multimedia, ArrayList<Socio>socios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el título que quiera alquilar el socio");
        String titMult = sc.nextLine();
        if (buscarTitulo(titMult, multimedia) != -1) {
            System.out.println("Introduce el NIF del socio");
            String nif = sc.nextLine();
            if (buscarSocio(nif, socios) != -1) {
                if (socios.get(buscarSocio(nif, socios)).getRecargo() == 0) {
                    socios.get(buscarSocio(nif, socios)).setRecargo(calcularPrecio(multimedia.get(buscarTitulo(titMult, multimedia))));
                    socios.get(buscarSocio(nif, socios)).getHistorial().add(multimedia.get(buscarTitulo(titMult, multimedia)));
                    socios.get(buscarSocio(nif, socios)).getAlquilerActual().add(multimedia.get(buscarTitulo(titMult, multimedia)));
                } else {
                    System.out.println("Socio con recargos. No puede alquilar");
                }
            } else {
                System.out.println("No se ha encontrado el socio");
            }
        } else {
            System.out.println("No se ha encontrado el título");
        }
    }

    public static int calcularPrecio(Multimedia m) {
        int precio = 4;
        if (tipoMultimedia(m) == 0) {
            if (m.getAnio() < 2012) {
                precio = precio - 1;
            }
        } else if (tipoMultimedia(m) == 1) {
            if (m.getAnio() < 2010) {
                precio = precio - 1;
            }
        }
        return precio;
    }

    public static void devolverMult(ArrayList<Multimedia>multimedia, ArrayList<Socio>socios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el titulo que se va a devolver");
        String titMult = sc.nextLine();
        if (buscarTitulo(titMult, multimedia) != -1) {
            System.out.println("Introduce el NIF del socio");
            String nif = sc.nextLine();
            if (buscarSocio(nif, socios) != -1) {
                if (buscarTituloAlquilados(titMult, socios.get(buscarSocio(nif, socios))) != -1) {
                    System.out.println("Introduce los dias pasados desde que se realizó el alquiler");
                    int dias = sc.nextInt();
                    socios.get(buscarSocio(nif, socios)).getAlquilerActual().remove(buscarTituloAlquilados(titMult, socios.get(buscarSocio(nif, socios))));
                    socios.get(buscarSocio(nif, socios)).setRecargo(socios.get(buscarSocio(nif, socios)).getRecargo() + calcularRecargoDev(dias));
                } else {
                    System.out.println("Este título no ha sido alquilado por el socio");
                }
            } else {
                System.out.println("No se ha encontrado el socio");
            }
        } else {
            System.out.println("No se ha encontrado el título");
        }
    }
    public static int calcularRecargoDev(int dias) {
        int recargo = 0;
        if (dias > 3) {
            recargo = 2 * (dias-3);
        }
        return recargo;
    }
    public static String pagarRecargo(ArrayList<Socio>socios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica que socio va a realizar el pago");
        String nif = sc.nextLine();
        if (buscarSocio(nif, socios) != -1) {
            socios.get(buscarSocio(nif, socios)).setRecargo(0);
            return "Se ha pagado los recargos pendientes";
        } else {
            return "No se ha encontrado el socio";
        }
    }
    public static int buscarTitulo(String titulo, ArrayList<Multimedia>multimedia) {
        int index = 0;
        for (int i = 0; i < multimedia.size(); i++) {
            if (multimedia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    public static int buscarTituloAlquilados(String titulo, Socio s) {
        int index = 0;
        for (int i = 0; i < s.getHistorial().size(); i++) {
            if (s.getHistorial().get(i).getTitulo().equalsIgnoreCase(titulo)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    public static int buscarSocio(String nif, ArrayList<Socio>socios) {
        int index = 0;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getNif().equalsIgnoreCase(nif)) {
                index = i;
                return index;
            }
        }
        return -1;
    }
    public static void listados(ArrayList<Multimedia>multimedia, ArrayList<Socio>socios) {
        Scanner sc= new Scanner(System.in);
        int op;
        do {
            System.out.println("""
                   1. Listado de todos los objetos multimedia
                   2. Listado de todas las películas ordenadas por título
                   3. Listado de todos los videojuegos ordenados por año
                   4. Listado del histórico de alquileres de un socio ordenados por fecha de alquiler
                   5. Listado de los alquileres actuales de un socio
                   6. Listado de los socios con recargos pendientes
                    --------------------------------
                    0. Volver al menú principal    
                    """);
            op = sc.nextInt();
            switch (op) {
                case 1 -> listaMultimedia(multimedia);
                case 2 -> listaPeliculas(multimedia);
                case 3 -> listaVideojuegos(multimedia);
                case 4 -> listaHistorial(socios);
                case 5 -> listaAlquilerActual(socios);
                case 6 -> listaRecargosPendientes(socios);
                case 0 -> System.out.println("Volver al menú principal");
            }
        }while(op != 0);
    }
    public static void listaMultimedia(ArrayList<Multimedia>multimedia) {
        for (Multimedia m: multimedia) {
            System.out.println(m);
            System.out.println("--------------------------");

        }
    }
    public static void listaPeliculas(ArrayList<Multimedia>multimedia) {
        ArrayList <Pelicula> peliculas = new ArrayList<>();
        for (Multimedia m : multimedia) {
            if (tipoMultimedia(m) == 0) {
                peliculas.add((Pelicula) m);
            }
        }
        peliculas.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula p1, Pelicula p2) {
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        });
        for (Pelicula p : peliculas) {
            System.out.println(p);
            System.out.println("--------------------------");
        }
    }

    public static void listaVideojuegos(ArrayList<Multimedia>multimedia) {
        ArrayList <Videojuego> videojuegos = new ArrayList<>();
        for (Multimedia m : multimedia) {
            if (tipoMultimedia(m) == 1) {
                videojuegos.add((Videojuego) m);
            }
        }
        videojuegos.sort(new Comparator<Videojuego>() {
            public int compare(Videojuego v1, Videojuego v2) {
                return Integer.compare(v1.getAnio(), (v2.getAnio()));
            }
        });
        for (Videojuego v : videojuegos) {
            System.out.println(v);
            System.out.println("--------------------------");
        }
    }

    public static void listaHistorial(ArrayList<Socio>socios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF del socio que quieras consultar");
        String nif = sc.nextLine();
        if (buscarSocio(nif, socios) != -1) {
            try {
                System.out.println("Histórico de alquileres del socio");
                System.out.println("-----------------------------------------");
                for (int i = 0; i < socios.get(buscarSocio(nif, socios)).getHistorial().size(); i++) {
                    System.out.println(socios.get(buscarSocio(nif, socios)).getHistorial().get(i));
                    System.out.println("--------------------------");
                }
            } catch (Exception e) {
                System.out.println("El historial está vacio");
            }
        } else {
            System.out.println("No se ha encontrado el socio");
        }
    }

    public static void listaAlquilerActual(ArrayList<Socio>socios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el NIF del socio que quieras consultar");
        String nif = sc.nextLine();
        if (buscarSocio(nif, socios) != -1) {
            try {
                System.out.println("Alquileres actuales del socio");
                System.out.println("-----------------------------------------");

                for (int i = 0; i < socios.get(buscarSocio(nif, socios)).getAlquilerActual().size(); i++) {
                    System.out.println(socios.get(buscarSocio(nif, socios)).getAlquilerActual().get(i));
                }
            } catch (Exception e) {
                System.out.println("No hay alquileres actuales");
            }
        } else {
            System.out.println("No se ha encontrado el socio");
        }
    }

    public static void listaRecargosPendientes(ArrayList<Socio>socios) {
        System.out.println("Socios con recargos pendientes");
        System.out.println("-----------------------------------------");
        for (Socio s: socios) {
            if (s.getRecargo() > 0) {
                System.out.println(s.getNombre() + "\nRecargo pendiente: " + s.getRecargo() + "\n---------------");
            }
        }
    }
    public static int tipoMultimedia(Multimedia m) {
        if (m instanceof Pelicula) {
            return 0;
        } else if (m instanceof Videojuego) {
            return 1;
        }
        return -1;
    }
}
