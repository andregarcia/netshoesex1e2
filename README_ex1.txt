

GET:

Obt�m um registro de cep. Caso o cep n�o seja encontrado, os digitos s�o substitu�dos por zero, da direita para a esquerda, at� que se encontre um cep ou at� todos os d�gitos serem substituidos por 0.

Os ceps atualmente cadastrados s�o:
01311000
05426200
05402000
04013040
01418000


endpoint:
http://localhost:8080/netshoesex1e2/zipcode/{zipcode}

{zipcode} deve ser um cep v�lido (i.e. constitu�do por 8 digitos, sem tra�o) e existente na base 

exemplo de GET:
curl -X GET http://localhost:8080/netshoesex1e2/zipcode/01311000  -v

status codes:
200 (ok): o cep foi encontrado
404 (not found): o cep n�o foi encontrado
400 (bad request): o formato do cep � inv�lido


exemplo de resposta quando o cep � encontrado:
{"zipcode":"01311000","street":"Avenida Paulista","district":"Bela Vista","city":"S�o Paulo","state":"SP"}

