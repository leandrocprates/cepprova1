# Projeto WebService Busca , Criacao , Alteracao e Delete de Enderecos 


Foi criado uma interface com uma tela chamada **cep.html** onde inicialmente quando o usuario acesso o portal 
ele visualiza um link no topo da tela para:

* Busca de endereco por CEP
* Inserir um novo Endereco 
* Listar todos os enderecos cadastrado 

A  busca de um cep que se retornara na lista ```Resultado Busca por CEP```

O projeto foi desenvolvido utilizando a implementacao de referencia de WebService Rest (Jersey) ,  AngulaJS para criar as VIEWS   e Bootstrap , e no lado do Servidor JAX-RS  utilizando Json para receber e retornar objetos e Listas  de 
Enderecos para aquele CEP. 

Foi criado um arquivo **cepController.js** que controla todas as acoes do usuario com a tela e efetua as requisiçoes de insercao atualizacao e delete de endereços utilizando os serviço criado presente na classe  **EnderecoService.java** apresentada abaixo.


Os endereços cadastrado na aplicação foram armazenados na memoria **mapDeEnderecos** , e toda a atualização e delete dos registros serao feitos neste map. 

```
Descricao dos serviços: 

1 - Url de consulta de um cep , utiliza Metodo @GET - public Response getMsg(@PathParam("param") String cep)  ; 

http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/02560-079 

2 - Url de cadastro de endereço, utiliza Metodo @POST - public Response addEndereco(Endereco  endereco);

http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/addEndereco

3 - Url de lista todos os Enderecos , utiliza Metodo @GET - public Response getListaEnderecos() ;

http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/listarEnderecos

4 - Url delete Endereco, utiliza Metodo @DELETE - public Response deleteRegistro(Endereco  endereco);

http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/excluirEndereco

```

A assinatura das funcões e sua funcionalidade esta descrita abaixo: 


```javascript



@Path("/buscaEndereco")
public class EnderecoService {
	// Armazena enderecos cadastrados     
        static HashMap mapDeEnderecos = new HashMap<Integer, Endereco>(); 
    
        static int idEndereco = 1 ; 

	/*Funcao responsavel pela consulta do CEP */ 
	@GET
	@Path("/{param}")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String cep) {
        }

	/*Funcao responsavel pela adição de novo Endereco */ 
        @POST
        @Path("/addEndereco")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addEndereco(Endereco  endereco){
        }
        
        /*Funcao responsavel por listar todos os Enderecos cadastrados */
	@GET
	@Path("/listarEnderecos")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getListaEnderecos() {
        }
        
        /*Funcao responsavel por deletar Endereco cadastrado */
        @DELETE
        @Path("/excluirEndereco")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response deleteRegistro(Endereco  endereco){
        }

	/*Busca cep por 04551999 , 04551990 , 04551900 ou 04551000  */        
        public Endereco buscaCep(char cepArray []){
        }
        
        /*Funcao responsavel por  validar o Cep*/
        public boolean validaCep(String cep)
        {
        }        
        
}

```




