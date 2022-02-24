package br.inatel.model;
import lombok.Data;

@Data
public class Jogo {
    private int rank;
    private String name;
    private String platform;
    private int year;
    private String global_sales;
    private String publisher;
}
