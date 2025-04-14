import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaSimples implements IEstruturaSimples {

    private List<Object> elementos;
    private int capacidadeInicial = 10;

    public ListaSimples() {
        this.elementos = new ArrayList<>(capacidadeInicial);
    }

    @Override
    public void inserirElemento(Object elemento) {
        this.elementos.add(elemento);
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (indice < 0 || indice > this.elementos.size()) {
            System.out.println("Índice inválido.");
            return;
        }
        this.elementos.add(indice, elemento);
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (elementos instanceof List) {
            this.elementos.addAll((List<?>) elementos);
        } else if (elementos instanceof Object[]) {
            this.elementos.addAll(Arrays.asList((Object[]) elementos));
        } else {
            System.out.println("Tipo de sequência não suportado.");
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            System.out.println("A lista está vazia, não é possível remover.");
            return false;
        }
        this.elementos.remove(this.elementos.size() - 1);
        return true;
    }

    @Override
    public Object removerIndice(int indice) {
        if (indice < 0 || indice >= this.elementos.size()) {
            System.out.println("Índice inválido.");
            return null;
        }
        return this.elementos.remove(indice);
    }

    @Override
    public void removerSequencia(Object elementos) {
        if (elementos instanceof List) {
            this.elementos.removeAll((List<?>) elementos);
        } else if (elementos instanceof Object[]) {
            this.elementos.removeAll(Arrays.asList((Object[]) elementos));
        } else {
            System.out.println("Tipo de sequência não suportado.");
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        this.elementos.removeAll(Collections.singleton(elemento));
    }

    @Override
    public boolean estaCheia() {
        return false; // Uma ArrayList não tem um limite fixo, então nunca estará "cheia" no sentido tradicional.
    }

    @Override
    public boolean estaVazia() {
        return this.elementos.isEmpty();
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        return this.elementos.contains(elemento);
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if (indice < 0 || indice >= this.elementos.size()) {
            System.out.println("Índice inválido.");
            return null;
        }
        return this.elementos.get(indice);
    }

    @Override
    public void ordenarCrescente() {
        try {
            Collections.sort((List<? extends Comparable>) this.elementos);
        } catch (ClassCastException e) {
            System.out.println("Erro: Os elementos da lista não são comparáveis.");
        }
    }

    @Override
    public void ordenarDecrescente() {
        try {
            Collections.sort((List<? extends Comparable>) this.elementos, Collections.reverseOrder());
        } catch (ClassCastException e) {
            System.out.println("Erro: Os elementos da lista não são comparáveis.");
        }
    }

    @Override
    public int quantidadeElementos() {
        return this.elementos.size();
    }

    @Override
    public void dobrarCapacidade() {

        int novaCapacidade = this.elementos.size() * 2;
        ArrayList<Object> novaLista = new ArrayList<>(novaCapacidade);
        novaLista.addAll(this.elementos);
        this.elementos = novaLista;
        System.out.println("Capacidade da lista dobrada para: " + novaCapacidade);
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        int indice = this.elementos.indexOf(elementoAntigo);
        if (indice != -1) {
            this.elementos.set(indice, elementoNovo);
        } else {
            System.out.println("Elemento antigo não encontrado na lista.");
        }
    }

    @Override
    public void limpar() {
        this.elementos.clear();
        System.out.println("A lista foi limpa.");
    }

    @Override
    public void exibir() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }
        System.out.println("Elementos da lista: " + this.elementos);
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return null;
        }
        return this.elementos.get(0);
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return null;
        }
        return this.elementos.get(this.elementos.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimples lista = new ListaSimples();
        int opcao;

        do {
            System.out.println("\n----- Menu da Lista Simples -----");
            System.out.println("1. Inserir Elemento");
            System.out.println("2. Inserir Elemento por Índice");
            System.out.println("3. Inserir Sequência de Elementos");
            System.out.println("4. Remover Último Elemento");
            System.out.println("5. Remover Elemento por Índice");
            System.out.println("6. Remover Sequência de Elementos");
            System.out.println("7. Remover Todas as Ocorrências de um Elemento");
            System.out.println("8. Verificar se a Lista está Cheia");
            System.out.println("9. Verificar se a Lista está Vazia");
            System.out.println("10. Buscar Elemento");
            System.out.println("11. Buscar Elemento por Índice");
            System.out.println("12. Ordenar Crescente");
            System.out.println("13. Ordenar Decrescente");
            System.out.println("14. Obter Quantidade de Elementos");
            System.out.println("15. Dobrar Capacidade");
            System.out.println("16. Editar Elemento");
            System.out.println("17. Limpar Lista");
            System.out.println("18. Exibir Lista");
            System.out.println("19. Obter Primeiro Elemento");
            System.out.println("20. Obter Último Elemento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    lista.inserirElemento(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Digite o elemento a ser inserido: ");
                    String elementoIndice = scanner.nextLine();
                    System.out.print("Digite o índice para inserção: ");
                    int indiceInsercao = scanner.nextInt();
                    scanner.nextLine();
                    lista.inserirElementoIndice(elementoIndice, indiceInsercao);
                    break;
                case 3:
                    System.out.print("Digite os elementos a serem inseridos (separados por vírgula): ");
                    String[] elementosSequencia = scanner.nextLine().split(",");
                    List<String> listaSequencia = new ArrayList<>(Arrays.asList(elementosSequencia));
                    lista.inserirSequencia(listaSequencia);
                    break;
                case 4:
                    if (lista.removerElemento()) {
                        System.out.println("Último elemento removido.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o índice do elemento a ser removido: ");
                    int indiceRemocao = scanner.nextInt();
                    scanner.nextLine();
                    Object elementoRemovido = lista.removerIndice(indiceRemocao);
                    if (elementoRemovido != null) {
                        System.out.println("Elemento no índice " + indiceRemocao + " removido: " + elementoRemovido);
                    }
                    break;
                case 6:
                    System.out.print("Digite os elementos a serem removidos (separados por vírgula): ");
                    String[] elementosRemoverSequencia = scanner.nextLine().split(",");
                    List<String> listaRemoverSequencia = new ArrayList<>(Arrays.asList(elementosRemoverSequencia));
                    lista.removerSequencia(listaRemoverSequencia);
                    break;
                case 7:
                    System.out.print("Digite o elemento a ser removido (todas as ocorrências): ");
                    lista.removerTodasOcorrencias(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("A lista está cheia? " + lista.estaCheia());
                    break;
                case 9:
                    System.out.println("A lista está vazia? " + lista.estaVazia());
                    break;
                case 10:
                    System.out.print("Digite o elemento a ser buscado: ");
                    System.out.println("Elemento encontrado? " + lista.buscarElemento(scanner.nextLine()));
                    break;
                case 11:
                    System.out.print("Digite o índice do elemento a ser buscado: ");
                    int indiceBusca = scanner.nextInt();
                    scanner.nextLine();
                    Object elementoBuscado = lista.buscarElementoIndice(indiceBusca);
                    if (elementoBuscado != null) {
                        System.out.println("Elemento no índice " + indiceBusca + ": " + elementoBuscado);
                    }
                    break;
                case 12:
                    lista.ordenarCrescente();
                    System.out.println("Lista ordenada crescentemente.");
                    break;
                case 13:
                    lista.ordenarDecrescente();
                    System.out.println("Lista ordenada decrescentemente.");
                    break;
                case 14:
                    System.out.println("Quantidade de elementos na lista: " + lista.quantidadeElementos());
                    break;
                case 15:
                    lista.dobrarCapacidade();
                    break;
                case 16:
                    System.out.print("Digite o elemento antigo a ser editado: ");
                    String elementoAntigo = scanner.nextLine();
                    System.out.print("Digite o novo elemento: ");
                    String elementoNovo = scanner.nextLine();
                    lista.editarElemento(elementoAntigo, elementoNovo);
                    break;
                case 17:
                    lista.limpar();
                    break;
                case 18:
                    lista.exibir();
                    break;
                case 19:
                    Object primeiro = lista.obterPrimeiroElemento();
                    if (primeiro != null) {
                        System.out.println("Primeiro elemento: " + primeiro);
                    }
                    break;
                case 20:
                    Object ultimo = lista.obterUltimoElemento();
                    if (ultimo != null) {
                        System.out.println("Último elemento: " + ultimo);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}