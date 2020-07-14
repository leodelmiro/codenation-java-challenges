package br.com.codenation;

import br.com.codenation.entities.Jogador;
import br.com.codenation.entities.Time;
import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
    private final List<Time> times = new ArrayList<>();
    private final List<Jogador> todosJogadores = new ArrayList<>();

    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        if (times.stream().anyMatch(time -> time.getId().equals(id))) {
            throw new IdentificadorUtilizadoException();
        }
        Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        times.add(time);
    }

    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }
        Time time = buscarTime(idTime);
        if (time.todosJogadores().stream().anyMatch(jogador -> jogador.getId().equals(id))){
            throw new IdentificadorUtilizadoException();
        }

        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        time.adicionarJogador(jogador);
        todosJogadores.add(jogador);
    }

    public void definirCapitao(Long idJogador) {
        if (todosJogadores.stream().noneMatch(jogador -> jogador.getId().equals(idJogador))){
            throw new JogadorNaoEncontradoException();
        }

        Jogador jogador = buscarJogador(idJogador);
        Time time = buscarTime(jogador.getIdTime());

        time.setCapitao(idJogador);
    }

    public Long buscarCapitaoDoTime(Long idTime) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        Time time = buscarTime(idTime);
        if (time.getCapitao() == null){
            throw new CapitaoNaoInformadoException();
        }

        return time.getCapitao();
    }

    public String buscarNomeJogador(Long idJogador) {
        if (todosJogadores.stream().noneMatch(jogador -> jogador.getId().equals(idJogador))) {
            throw new JogadorNaoEncontradoException();
        }

        return buscarJogador(idJogador).getNome();
    }

    public String buscarNomeTime(Long idTime) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        return buscarTime(idTime).getNome();
    }

    public List<Long> buscarJogadoresDoTime(Long idTime) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        Time time = buscarTime(idTime);

        if (time.todosJogadores().isEmpty()){
            throw new JogadorNaoEncontradoException();
        }

        return time.todosJogadores().stream().map(Jogador::getId).collect(Collectors.toList());
    }

    public Long buscarMelhorJogadorDoTime(Long idTime) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        Time time = buscarTime(idTime);
        if (time.todosJogadores().isEmpty()){
            throw new JogadorNaoEncontradoException();
        }

        List<Jogador> classificacaoMelhoresJogadores = time.todosJogadores().stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()).collect(Collectors.toList());
        return classificacaoMelhoresJogadores.get(0).getId();
    }

    public Long buscarJogadorMaisVelho(Long idTime) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        Time time = buscarTime(idTime);
        if (time.todosJogadores().isEmpty()){
            throw new JogadorNaoEncontradoException();
        }

        List<Jogador> classificacaoJogadorMaisVelho = time.todosJogadores().stream().sorted(Comparator.comparing(Jogador::getDataNascimento)).collect(Collectors.toList());
        return classificacaoJogadorMaisVelho.get(0).getId();
    }

    public List<Long> buscarTimes() {
        List<Long> timesEncontrados = new ArrayList<>();
        if (times.isEmpty()) {
            return timesEncontrados;
        }
        timesEncontrados = times.stream().map(Time::getId).collect(Collectors.toList());
        return timesEncontrados;
    }

    public Long buscarJogadorMaiorSalario(Long idTime) {
        if (times.stream().noneMatch(time -> time.getId().equals(idTime))) {
            throw new TimeNaoEncontradoException();
        }

        Time time = buscarTime(idTime);
        if (time.todosJogadores().isEmpty()){
            throw new JogadorNaoEncontradoException();
        }

        List<Jogador> classificacaoMaiorSalario = time.todosJogadores().stream().sorted(Comparator.comparing(Jogador::getSalario).reversed()).collect(Collectors.toList());
        return classificacaoMaiorSalario.get(0).getId();
    }

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        if (todosJogadores.stream().noneMatch(jogador -> jogador.getId().equals(idJogador))){
            throw new JogadorNaoEncontradoException();
        }

        return buscarJogador(idJogador).getSalario();
    }

    public List<Long> buscarTopJogadores(Integer top) {
        List<Jogador> classificaoNivelJogadores = todosJogadores.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()).collect(Collectors.toList());
        List<Long> topJogadores = new ArrayList<>();
        if(todosJogadores.isEmpty()){
            return topJogadores;
        }
        for (int i = 0; i < top; i++){
            topJogadores.add(classificaoNivelJogadores.get(i).getId());
        }
        return topJogadores;
    }

    public Time buscarTime(Long idTime) {
        List<Time> timeEncontrado = times.stream().filter(time -> time.getId().equals(idTime)).collect(Collectors.toList());
        return timeEncontrado.get(0);
    }

    public Jogador buscarJogador(Long idJogador){
        List<Jogador> jogadorEncontrado = todosJogadores.stream().filter(jogador -> jogador.getId().equals(idJogador)).collect(Collectors.toList());
        return jogadorEncontrado.get(0);
    }
}
