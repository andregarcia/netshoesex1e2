# Netshoes Exercícios 1 e 2

Este projeto implementa as soluções para os exercícios 1 e 2 do teste para o Netshoes.

A documentação a seguir assume que a aplicação web está sendo executada localmente na porta 8080.

# Exercício 1
Neste exercício é implementado um serviço de busca por CEP. Os ceps atualmente cadastrados são:  
01311000  
05426200  
05402000  
04013040  
01418000  

A seguir as operações possíveis neste serviço:

##### GET (/zipcode/{zipcode}):  
Obtém um registro de cep. Caso o cep não seja encontrado, os digitos são substituídos por zero, da direita para a esquerda, até que se encontre um cep ou até todos os dígitos serem substituidos por 0.

Os ceps atualmente cadastrados são:  
01311000  
05426200  
05402000  
04013040  
01418000

endpoint:  
http://localhost:8080/netshoesex1e2/zipcode/{zipcode}  
{zipcode} deve ser um cep válido (i.e. constituído por 8 digitos, sem traço) e existente na base 

exemplo de GET:  
curl -X GET http://localhost:8080/netshoesex1e2/zipcode/01311000  -v

status codes:  
200 (ok): o cep foi encontrado  
404 (not found): o cep não foi encontrado  
400 (bad request): o formato do cep é inválido  


exemplo de resposta quando o cep é encontrado:  
{"zipcode":"01311000","street":"Avenida Paulista","district":"Bela Vista","city":"São Paulo","state":"SP"}



# Exercício 2:

Neste exercício é implementado um CRUD de endereços.

A seguir são listadas as operações possíveis neste serviço.

#####  POST (/address):

Cria um novo registro de endereço. O cep do registro deve estar cadastrado e os campos street, number, zipcode, city, state são obrigatórios. Os campos district e complement são opcionais.

endpoint:  
http://localhost:8080/netshoesex1e2/address

exemplo de json a ser postado:  
{"street" : "Avenida Paulista", "number" : "1", "zipcode" : "01311000", "city" : "São Paulo", "state" : "SP", "district":"Bela Vista","complement":"Loja B"}

exemplo de POST:  
curl -X POST -H 'Content-type: application/json' -d '{"street" : "Avenida Paulista", "number" : "1", "zipcode" : "01311000", "city" : "São Paulo", "state" : "SP", "district":"Bela Vista","complement":"Loja B"}' http://localhost:8080/netshoesex1e2/address -v

status codes:  
201 (created): o registro foi criado com sucesso  
400 (bad request): o cep é inválido ou um dos campos obrigatórios está nulo ou vazio

exemplo de resposta (mesmo json da requisição, mas contendo o id do registro criado)  
{"id":1,"street":"Avenida Paulista","number":"1","zipcode":"01311000","city":"São Paulo","state":"SP","district":"Bela Vista","complement":"Loja B"}






#####  GET (/address/{id}):

Obtém um registro de endereço.

endpoint:  
http://localhost:8080/netshoesex1e2/address/{id}  
{id} deve ser um id de endereço válido

exemplo de GET:  
curl -X GET http://localhost:8080/netshoesex1e2/address/1 -v

status codes:  
200 (OK): o endereço foi encontrado (id existe) e é retornado como json  
404 (not found): o id não existe

exemplo de resposta:  
{"id":1,"street":"Avenida Paulista","number":"1","zipcode":"01311000","city":"São Paulo","state":"SP","district":null,"complement":null}



#####  PUT (/address):

Atualiza um registro de endereço dado seu id. Os campso id, street, number, zipcode, city, state são obrigatórios. Os campos district e complement são opcionais.

endpoint:  
http://localhost:8080/netshoesex1e2/address

exemplo de PUT:  
curl -X PUT -H 'Content-type: application/json' -d '{"id": "1", "street" : "Avenida Paulista", "number" : "50", "zipcode" : "01311000", "city" : "São Paulo", "state" : "SP"}' http://localhost:8080/netshoesex1e2/address -v

status codes:  
204 (no content): o registro foi atualizado com sucesso  
404 (not found): o id de endereço a ser atualizado não existe  
400 (bad request): o novo cep é inválido ou um dos campos obrigatórios está nulo ou vazio



#####  DELETE (/address/{id}):

Apaga um registro de endereço dado seu id.

endpoint:  
http://localhost:8080/netshoesex1e2/address/{id}  
{id} deve ser um id de endereço válido

exemplo de DELETE:  
curl -X DELETE http://localhost:8080/netshoesex1e2/address/1 -v

status codes:  
204 (no content): o registro foi apagado com sucesso  
404 (not found): o id de endereço a ser apagado não existe  
400 (bad request): o id de endereço é inválido  





