<p align="center"><img id="springlogo" class="block" src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" alt="Spring" height="60" width="250" ></p>

<p align="center">
<a href="https://ci.spring.io/teams/spring-boot/pipelines/spring-boot-3.0.x?groups=Build" rel="nofollow"><img src="https://camo.githubusercontent.com/f2cbda44c77ea6d3cb5dafc46c576aebb07fe4528016bfac2430ea8ecb73d58a/68747470733a2f2f63692e737072696e672e696f2f6170692f76312f7465616d732f737072696e672d626f6f742f706970656c696e65732f737072696e672d626f6f742d332e302e782f6a6f62732f6275696c642f6261646765" alt="Build Status" data-canonical-src="https://ci.spring.io/api/v1/teams/spring-boot/pipelines/spring-boot-3.0.x/jobs/build/badge" style="max-width: 100%;"></a>
<a href="https://gitter.im/spring-projects/spring-boot?utm_source=badge&amp;utm_medium=badge&amp;utm_campaign=pr-badge&amp;utm_content=badge" rel="nofollow"><img src="https://camo.githubusercontent.com/5dbac0213da25c445bd11f168587c11a200ba153ef3014e8408e462e410169b3/68747470733a2f2f6261646765732e6769747465722e696d2f4a6f696e253230436861742e737667" alt="Chat" data-canonical-src="https://badges.gitter.im/Join%20Chat.svg" style="max-width: 100%;"></a>
<a href="https://ge.spring.io/scans?&amp;search.rootProjectNames=Spring%20Boot%20Build&amp;search.rootProjectNames=spring-boot-build" rel="nofollow"><img src="https://camo.githubusercontent.com/077dbe87ec44e1f7ca17e7a75b0c646bc2b44851e1bf530482404b6b59e0d60d/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f526576766564253230757025323062792d477261646c65253230456e74657270726973652d3036413043453f6c6f676f3d477261646c65266c6162656c436f6c6f723d303233303341" alt="Revved up by Gradle Enterprise" data-canonical-src="https://img.shields.io/badge/Revved%20up%20by-Gradle%20Enterprise-06A0CE?logo=Gradle&amp;labelColor=02303A" style="max-width: 100%;"></a>
</p>

# Descrição
Backend de integração que converte xml para json.

## Tecnologias utilizadas:
- [ ] Java/Sprintboot para construção do backend;
- [ ] Feign para integração com webservice externo;
- [ ] Swagger para documentação;

### Possíveis Melhorias:
- [ ] Implementar JWT;
- [ ] Abstrair classe da chamada ao webservice;

## Como executar o projeto
Para executar o projeto você precisa ter o Java 17, Spring Boot na versão 3.0.0-M2 e maven 3.8.5.

Siga os passos:

- clone este repositório.
- entre na pasta.
- abra o projeto no Intellij e importe as variáveis do arquivo env_vars.
- execute os comandos:


	$ mvn clean install
	$ mvn spring-boot:run

## Como subir a imagem docker
No Linux, instale o Docker e suba o serviço com o comando:

	$ sudo service docker start && sudo docker swarm init	
Vá até a pasta raiz do projeto (onde se encontra o arquivo Dockerfile) e execute o comando:

	$ sudo docker build -t batistabjs/xml-2-json:xml-2-json-v1 .
Verifique se a imagem fora criada:

	$ sudo docker image ls
Em seguida, execute o seguinte comando para subir o container do integrador:

	$ sudo docker container run -d --name nome_do_servico -p 9016:9016 batistabjs/xml-2-json:xml-2-json-v1	

    $ sudo ctop	

## License
Spring Boot is Open Source software released under the <a href="https://www.apache.org/licenses/LICENSE-2.0.html">Apache 2.0 license.
