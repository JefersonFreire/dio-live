package onedigitalinnovation;

import onedigitalinnovation.dominio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Curso cursoJavaBasico = new Curso();
        cursoJavaBasico.setTitulo("Java Básico");
        cursoJavaBasico.setDescricao("Conceitos básicos sobre Java.");
        cursoJavaBasico.setCargaHoraria(8);

        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda conceitos avançados sobre Java.");
        cursoJavaAvancado.setCargaHoraria(8);

        Curso cursoDotNet = new Curso();
        cursoDotNet.setTitulo(".Net");
        cursoDotNet.setDescricao("Aprenda conceito básicos sobre C#.");
        cursoDotNet.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
        mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos.");
        mentoria.setData(LocalDateTime.now());

        BootcampLive bootcamp = new BootcampLive();
        bootcamp.setNome("Java");
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
        bootcamp.setConteudos(conteudosBootcamp);

        Dev jeferson = new Dev();
        jeferson.setNome("Jeferson");

        Dev freire = new Dev();
        freire.setNome("Freire");

        jeferson.inscrever(cursoDotNet);
        jeferson.inscrever(bootcamp);
        jeferson.progredir();
        jeferson.progredir();


        freire.inscrever(bootcamp);
        freire.progredir();
        freire.progredir();
        freire.progredir();

        System.out.println(String.format("XP Jeferson: %.2f", jeferson.calcularTotalXp()));
        System.out.println(String.format("XP Freire: %.2f", freire.calcularTotalXp()));

        List<Dev> ranking = Arrays.asList(jeferson, freire).stream()
                .sorted((dev1, dev2) -> Double.compare(dev1.calcularTotalXp(), dev2.calcularTotalXp()))
                .collect(Collectors.toList());
        for(Dev dev : ranking){
            System.out.println(dev.getNome());
        }
    }
}
