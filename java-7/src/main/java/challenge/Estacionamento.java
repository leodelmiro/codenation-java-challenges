package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private final Integer LIMITE_VAGAS = 10;
    private final Integer IDADE_MAIOR = 18;
    private final Integer LIMITE_PONTOS = 20;
    private final Integer IDADE_SENIOR = 55;
    List<Carro> vagas = new ArrayList<>();

    public void estacionar(Carro carro) {
        if ((carro.getMotorista() == null) ||
                (carro.getMotorista().getIdade() < IDADE_MAIOR) ||
                (carro.getMotorista().getPontos() > LIMITE_PONTOS) ||
                ((carrosEstacionados() >= LIMITE_VAGAS) && (saoTodosMotoristasSenior()))
        ) throw new EstacionamentoException();

        if (carrosEstacionados() < LIMITE_VAGAS) vagas.add(carro);
        if ((carrosEstacionados() >= LIMITE_VAGAS) && (!saoTodosMotoristasSenior())) {
            int primeiraVagaSemSenior = numeroDaVaga(primeiroCarroComMotoristaNaoSenior());
            vagas.remove(primeiraVagaSemSenior);
            vagas.add(carro);
        }
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }

    private boolean saoTodosMotoristasSenior() {
        for (Carro carro : vagas) {
            if (carro.getMotorista().getIdade() <= IDADE_SENIOR) return false;
        }
        return true;
    }

    private Carro primeiroCarroComMotoristaNaoSenior() {
        return vagas.stream().filter(c -> c.getMotorista().getIdade() <= IDADE_SENIOR).findFirst().get();
    }

    private Integer numeroDaVaga(Carro carro) throws NullPointerException {
        for (int i = 0; i < carrosEstacionados(); i++) {
            if (vagas.get(i).equals(carro)) {
                return i;
            }
        }
        return null;
    }
}
