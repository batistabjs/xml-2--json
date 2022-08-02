package com.github.integrador.conversor;

import com.github.integrador.conversor.utils.DecodeErrors;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.soap.*;

@RestController
@RequestMapping("/xml-2-json")
public class ConversorController {

    @Autowired
    private ConversorClient client;

    @Autowired
    private ConversorConfiguration clientconfig;

    @GetMapping("/{search}")
    public ResponseEntity<JSONObject> searchXML(@PathVariable("search") String search throws SOAPException {

        JSONObject dadosMedico;

        String payloadRequest = createXMLSOAPRequest(search.toUpperCase(), clientconfig.getPassword());
        String xmlResponse = client.searchXML(payloadRequest);

        JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
        dados = jsonResponse.getJSONObject("SOAP-ENV:Envelope")
                .getJSONObject("SOAP-ENV:Body")
                .getJSONObject("ns2:searchResponse")
                .getJSONObject("dados-XML");

        if (dados.has("codigoErro")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    DecodeErrors.decodeError(dados.getInt("codigoErro")));
        }

        return ResponseEntity.ok(dados);
    }

    private static String createXMLSOAPRequest(String search) throws SOAPException {

        SOAPMessage soapMessage;

        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("ser", "http://url-xml-sample.com/");


            // SOAP Body
            SOAPBody soapBody = envelope.getBody();
            soapBody.addChildElement("searchAction", "ser")
                    .addChildElement("search").addTextNode(search)
                    //.addChildElement("search2").addTextNode(uf);

            soapMessage.saveChanges();
        } catch (SOAPException se) {
            throw new SOAPException("Erro ao gerar corpo de requisição", se);
        }

        return soapMessage.toString();
    }
}
