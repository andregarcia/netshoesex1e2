# Netshoes Exerc�cios 1 e 2

Este projeto implementa as solu��es para os exerc�cios 1 e 2 do teste para o Netshoes.

A documenta��o a seguir assume que a aplica��o web est� sendo executada localmente na porta 8080.

# Exerc�cio 1
Neste exerc�cio � implementado um servi�o de busca por CEP. Os ceps atualmente cadastrados s�o:  
01311000  
05426200  
05402000  
04013040  
01418000  

A seguir as opera��es poss�veis neste servi�o:

&nbsp;  

##### GET (/zipcode/{zipcode}):  
Obt�m um registro de cep. Caso o cep n�o seja encontrado, os digitos s�o substitu�dos por zero, da direita para a esquerda, at� que se encontre um cep ou at� todos os d�gitos serem substituidos por 0.

Os ceps atualmente cadastrados s�o:  
01311000  
05426200  
05402000  
04013040  
01418000

**_endpoint_**:  
http://localhost:8080/netshoesex1e2/zipcode/{zipcode}  
{zipcode} deve ser um cep v�lido (i.e. constitu�do por 8 digitos, sem tra�o) e existente na base 

**_exemplo de GET_**:  
curl -X GET http://localhost:8080/netshoesex1e2/zipcode/01311000  -v

**_status codes_**:  
200 (ok): o cep foi encontrado  
404 (not found): o cep n�o foi encontrado  
400 (bad request): o formato do cep � inv�lido  


**_exemplo de resposta quando o cep � encontrado_**:  
{"zipcode":"01311000","street":"Avenida Paulista","district":"Bela Vista","city":"S�o Paulo","state":"SP"}


&nbsp;  

# Exerc�cio 2:

Neste exerc�cio � implementado um CRUD de endere�os.

A seguir s�o listadas as opera��es poss�veis neste servi�o.

&nbsp;  

#####  POST (/address):

Cria um novo registro de endere�o. O cep do registro deve estar cadastrado e os campos street, number, zipcode, city, state s�o obrigat�rios. Os campos district e complement s�o opcionais.

**_endpoint_**:  
http://localhost:8080/netshoesex1e2/address

**_exemplo de json a ser postado_**:  
{"street" : "Avenida Paulista", "number" : "1", "zipcode" : "01311000", "city" : "S�o Paulo", "state" : "SP", "district":"Bela Vista","complement":"Loja B"}

**_exemplo de POST_**:  
curl -X POST -H 'Content-type: application/json' -d '{"street" : "Avenida Paulista", "number" : "1", "zipcode" : "01311000", "city" : "S�o Paulo", "state" : "SP", "district":"Bela Vista","complement":"Loja B"}' http://localhost:8080/netshoesex1e2/address -v

**_status codes_**:  
201 (created): o registro foi criado com sucesso  
400 (bad request): o cep � inv�lido ou um dos campos obrigat�rios est� nulo ou vazio

**_exemplo de resposta_** (mesmo json da requisi��o, mas contendo o id do registro criado)  
{"id":1,"street":"Avenida Paulista","number":"1","zipcode":"01311000","city":"S�o Paulo","state":"SP","district":"Bela Vista","complement":"Loja B"}


&nbsp;  



#####  GET (/address/{id}):

Obt�m um registro de endere�o.

**_endpoint_**:  
http://localhost:8080/netshoesex1e2/address/{id}  
{id} deve ser um id de endere�o v�lido

**_exemplo de GET_**:  
curl -X GET http://localhost:8080/netshoesex1e2/address/1 -v

**_status codes_**:  
200 (OK): o endere�o foi encontrado (id existe) e � retornado como json  
404 (not found): o id n�o existe

**_exemplo de resposta_**:  
{"id":1,"street":"Avenida Paulista","number":"1","zipcode":"01311000","city":"S�o Paulo","state":"SP","district":null,"complement":null}

&nbsp;

#####  PUT (/address):

Atualiza um registro de endere�o dado seu id. Os campso id, street, number, zipcode, city, state s�o obrigat�rios. Os campos district e complement s�o opcionais.

**_endpoint_**:  
http://localhost:8080/netshoesex1e2/address

**_exemplo de PUT_**:  
curl -X PUT -H 'Content-type: application/json' -d '{"id": "1", "street" : "Avenida Paulista", "number" : "50", "zipcode" : "01311000", "city" : "S�o Paulo", "state" : "SP"}' http://localhost:8080/netshoesex1e2/address -v

**_status codes_**:  
204 (no content): o registro foi atualizado com sucesso  
404 (not found): o id de endere�o a ser atualizado n�o existe  
400 (bad request): o novo cep � inv�lido ou um dos campos obrigat�rios est� nulo ou vazio

&nbsp;  

#####  DELETE (/address/{id}):

Apaga um registro de endere�o dado seu id.

**_endpoint_**:  
http://localhost:8080/netshoesex1e2/address/{id}  
{id} deve ser um id de endere�o v�lido

**_exemplo de DELETE_**:  
curl -X DELETE http://localhost:8080/netshoesex1e2/address/1 -v

**_status codes_**:  
204 (no content): o registro foi apagado com sucesso  
404 (not found): o id de endere�o a ser apagado n�o existe  
400 (bad request): o id de endere�o � inv�lido  





