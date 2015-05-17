POST:

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






GET:

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







PUT:

Atualiza um registro de endereço dado seu id. Os campso id, street, number, zipcode, city, state são obrigatórios. Os campos district e complement são opcionais.

endpoint:
http://localhost:8080/netshoesex1e2/address

exemplo de PUT:
curl -X PUT -H 'Content-type: application/json' -d '{"id": "1", "street" : "Avenida Paulista", "number" : "50", "zipcode" : "01311000", "city" : "São Paulo", "state" : "SP"}' http://localhost:8080/netshoesex1e2/address -v

status codes:
204 (no content): o registro foi atualizado com sucesso
404 (not found): o id de endereço a ser atualizado não existe
400 (bad request): o novo cep é inválido ou um dos campos obrigatórios está nulo ou vazio






DELETE:

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


