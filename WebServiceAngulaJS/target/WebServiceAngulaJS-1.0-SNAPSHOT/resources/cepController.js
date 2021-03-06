/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var myAppModule = angular.module('mainApp', ['ngSanitize']);

myAppModule.controller("cepController", function ($scope,$http,$sce)
{
    $scope.person = {firstName:"John Maluco", lastName:"Doe", age:50, eyeColor:"blue"};
    
    function Endereco() {
        id=null;
        rua=null;
        bairro=null;
        cidade=null;
        estado=null;
        cep=null;
        msg=null;
        numero=null;
        complemento=null;
    };
    
    
    $scope.endereco = new Endereco(); 
    
    $scope.showdiv='BUSCA'; 
    
    $scope.cepDigitado='';
    $scope.endereco;
    $scope.mensagem='';
    $scope.insercaoMessage='';

    
    $scope.buscarEndereco = function(){
        
        var url='http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/'+$scope.cepDigitado ;
        
        $http.get(url)
                .success(function (data){
                    $scope.endereco=data;
                    $scope.mensagem =null;
                    console.log('Busca correta');
                })
                .error(function (data){
                    console.log('Erro na busca ');
                    $scope.mensagem = data.msg; 
                    $scope.endereco=null;
                });                
    };    
    
    
    $scope.inserirEndereco = function(){
        
        var url='http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/addEndereco' ;
        
        
        if ( validaComposObrigatorio() == false) {
            return;
        }
        
        
        $http.post(url,$scope.endereco)
                .success(function (data){
                    console.log('Endereco adicionado com sucesso.');
                    $scope.insercaoMessage='Endereco Inserido com sucesso.';
                    $scope.insercaoMessageErro='';
                })
                .error(function (data){
                    console.log('Erro ao adicionar endereco.');
                });
        
    };
    
    validaComposObrigatorio=function (){
        
        if ( ( angular.isUndefined($scope.endereco.rua) || $scope.endereco.rua == null )
                ||  ( angular.isUndefined($scope.endereco.numero) || $scope.endereco.numero == null )
                ||  ( angular.isUndefined($scope.endereco.cep) || $scope.endereco.cep == null )
                ||  ( angular.isUndefined($scope.endereco.cidade) || $scope.endereco.cidade == null )
                ||  ( angular.isUndefined($scope.endereco.estado) || $scope.endereco.estado == null )
                
            ) {
            
            $scope.insercaoMessageErro = 'Campos Rua/Cep/Numero/Cidade/Estado sao obrigatorios'; 
            return false;
        }
        return true;
        
    };
    
    
    $scope.alterarEndereco= function(endereco){
        $scope.endereco= endereco;
        $scope.showdiv='INSERIR';
    };
    
    $scope.excluir= function(endereco){
        $scope.endereco= endereco;
        
        var url='http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/excluirEndereco' ;
        
        var req = {
         method: 'DELETE',
         url: url,
         headers: {
           'Content-Type': 'application/json'
         },
         data: $scope.endereco
        };
        
        $http(req)
            .success(function (data){
                console.log('Endereco deletado com sucesso.');
                $scope.endereco = new Endereco(); 
                $scope.listarEnderecos();
            })
            .error(function (data){
                console.log('Erro ao deletar endereco.');
            });
        
        
        
    };
    
    
    
    
    
    
    $scope.listarEnderecos = function(){
        
        var url='http://localhost:8084/WebServiceAngulaJS/rest/buscaEndereco/listarEnderecos' ;
        
        $http.get(url)
                .success(function (data){
                    $scope.listaEndereco= ( data.length == 1 )?  new Array(data): data ;
                    console.log('Busca correta');
                })
                .error(function (data){
                    console.log('Erro na busca ');
                });                
    };
    
    $scope.irpara= function(irpara){
        $scope.showdiv=irpara; 
        
        $scope.insercaoMessageErro=null;
        $scope.insercaoMessage=null;
        
        if ($scope.showdiv == 'LISTAR' ){
            $scope.listarEnderecos();
        } else if ($scope.showdiv == 'INSERIR' ){
            $scope.endereco = new Endereco();    
        }
        
        
    };
    
    /*
    
    
    
    $scope.chamarGet = function(){
        
        var url='http://localhost:8080/WebServiceAngulaJS/rest/hello/getRegistro';
        
        $http.get(url)
                .success(function (data){
                    $scope.registro=data;
                    console.log('Busca correta');
                })
                .error(function (data){
                    console.log('Erro na busca ');
                });                
    };
    
    $scope.adicionarRegistro = function(){
        
        var url='http://localhost:8080/WebServiceAngulaJS/rest/hello/addRegistro';
        
        var registro2 = {coluna:"Nome", valor:"Jose 1"};
        registro2.usuario={nome: "Jose 2", telefone:"1122333018"};
        
        
        $http.post(url,registro2)
                .success(function (data){
                    console.log('Usuario adicionado com sucesso.');
                })
                .error(function (data){
                    console.log('Erro ao adicionar usuario.');
                });
    };

    
    $scope.deletarRegistro = function(){
        
        var url='http://localhost:8080/WebServiceAngulaJS/rest/hello/deleteRegistro';
        
        var registro2 = {coluna:"Nome", valor:"Jose 1"};
        registro2.usuario={nome: "Jose 2", telefone:"1122333018"};
        
        var req = {
         method: 'DELETE',
         url: url,
         headers: {
           'Content-Type': 'application/json'
         },
         data: registro2
        };
        
        //$http.delete(url,registro2)
        $http(req)
                .success(function (data){
                    console.log('Usuario deletado com sucesso.');
                })
                .error(function (data){
                    console.log('Erro ao deletar usuario.');
                });
    };
    
    */

    
    
});
    
