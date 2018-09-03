# livraria-EJB

1. Sistema utilizando Widfly 12.0

2. Banco de dados MySql 5.3

3. É necessário configurar o standalone do servidor com o seguinte codigo:

  <datasource jndi-name="java:/livrariaDS" pool-name="livrariaDS"
      enabled="true" use-java-context="true">

      <connection-url>jdbc:mysql://localhost:3306/livraria</connection-url>
      <driver>com.mysql</driver>
      <pool>
          <min-pool-size>10</min-pool-size>
          <max-pool-size>100</max-pool-size>
          <prefill>true</prefill>
      </pool>
      <security>
          <user-name>root</user-name>
          <password></password>
      </security>
  </datasource>

    <driver name="com.mysql" module="com.mysql">
        <xa-datasource-class>
            com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
        </xa-datasource-class>
    </driver>

Internamente o Widfly organiza seus módulos em pacotes, por isso devemos navegar para a pasta modules/com. 
Dentro da pasta com criaremos uma nova pasta mysql e dentro dela uma pasta main. Dentro da pasta main colocaremos
o arquivo modules.XML e o JAR (hierarquia final das pastas: jboss/modules/com/mysql/main)

O arquivo modules.xml deve conter o seguinte texto:

        <?xml version="1.0" encoding="UTF-8"?>

        <module xmlns="urn:jboss:module:1.0" name="com.mysql">
          <resources>
            <resource-root
              path="mysql-connector-java-5.1.24-bin.jar" />
          </resources>
          <dependencies>
            <module name="javax.api" />
          </dependencies>
        </module> 
o arquivo jar é o mysql-connector-java-5.1.24-bin.jar

4. Deve ser criado o database "livraria"
