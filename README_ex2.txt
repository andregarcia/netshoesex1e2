POST:

Cria um novo registro de endere�o. O cep do registro deve estar cadastrado e os campos street, number, zipcode, city, state s�o obrigat�rios. Os campos district e complement s�o opcionais.

endpoint:
http://localhost:8080/netshoesex1e2/address

exemplo de json a ser postado:
{"street" : "Avenida Paulista", "number" : "1", "zipcode" : "01311000", "city" : "S�o Paulo", "state" : "SP", "district":"Bela Vista","complement":"Loja B"}

exemplo de POST:
curl -X POST -H 'Content-type: application/json' -d '{"street" : "Avenida Paulista", "number" : "1", "zipcode" : "01311000", "city" : "S�o Paulo", "state" : "SP", "district":"Bela Vista","complement":"Loja B"}' http://localhost:8080/netshoesex1e2/address -v

status codes:
201 (created): o registro foi criado com sucesso
400 (bad request): o cep � inv�lido ou um dos campos obrigat�rios est� nulo ou vazio

exemplo de resposta (mesmo json da requisi��o, mas contendo o id do registro criado)
{"id":1,"street":"Avenida Paulista","number":"1","zipcode":"01311000","city":"S�o Paulo","state":"SP","district":"Bela Vista","complement":"Loja B"}






GET:

Obt�m um registro de endere�o.

endpoint:
http://localhost:8080/netshoesex1e2/address/{id}

{id} deve ser um id de endere�o v�lido

exemplo de GET:
curl -X GET http://localhost:8080/netshoesex1e2/address/1 -v

status codes:
200 (OK): o endere�o foi encontrado (id existe) e � retornado como json
404 (not found): o id n�o existe

exemplo de resposta:
{"id":1,"street":"Avenida Paulista","number":"1","zipcode":"01311000","city":"S�o Paulo","state":"SP","district":null,"complement":null}







PUT:

Atualiza um registro de endere�o dado seu id. Os campso id, street, number, zipcode, city, state s�o obrigat�rios. Os campos district e complement s�o opcionais.

endpoint:
http://localhost:8080/netshoesex1e2/address

exemplo de PUT:
curl -X PUT -H 'Content-type: application/json' -d '{"id": "1", "street" : "Avenida Paulista", "number" : "50", "zipcode" : "01311000", "city" : "S�o Paulo", "state" : "SP"}' http://localhost:8080/netshoesex1e2/address -v

status codes:
204 (no content): o registro foi atualizado com sucesso
404 (not found): o id de endere�o a ser atualizado n�o existe
400 (bad request): o novo cep � inv�lido ou um dos campos obrigat�rios est� nulo ou vazio






DELETE:

Apaga um registro de endere�o dado seu id.

endpoint:
http://localhost:8080/netshoesex1e2/address/{id}

{id} deve ser um id de endere�o v�lido

exemplo de DELETE:
curl -X DELETE http://localhost:8080/netshoesex1e2/address/1 -v

status codes:
204 (no content): o registro foi apagado com sucesso
404 (not found): o id de endere�o a ser apagado n�o existe
400 (bad request): o id de endere�o � inv�lido


