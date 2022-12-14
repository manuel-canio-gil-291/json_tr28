package es.mcg;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.mcg.errors.EventsError;
import es.mcg.input.data.DataInput;
import es.mcg.input.data.Outcome;
import es.mcg.input.data.Pass;
import es.mcg.input.data.Player;
import es.mcg.input.data.PossessionTeam;
import es.mcg.input.data.Recipient;
import es.mcg.input.data.Shot;
import es.mcg.input.data.Team;
import es.mcg.output.data.DataOutput;
import es.mcg.output.data.Goleador;
import es.mcg.output.data.PartidoCompleto;
import es.mcg.output.data.PorcentajesPosesion;
import es.mcg.output.data.PorteroJugador;
import es.mcg.output.data.PrimerTiempo;
import es.mcg.output.data.Referencia;
import es.mcg.output.data.SegundoTiempo;
import es.mcg.utils.Json;

public class EventsStatBomb {
    private static final String ENCODE = "UTF-8";
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws EventsError{
        File file = null, file2 = null;
        String fileContent;
        ObjectWriter objectWriter = null;
        List<DataInput> inputData = null;
        List<DataOutput> outputData = null;
        Goleador goleador = null;
        DataInput input = null;
        DataOutput output = null;
        Referencia referenciaEspania = null, referenciaItalia = null;
        PorteroJugador porteroJugador = null;
        PorcentajesPosesion porcentajesPosesion = null;
        PrimerTiempo primerTiempo = null;
        SegundoTiempo segundoTiempo = null;
        PartidoCompleto partidoCompleto = null;
        Integer pasePorteroItalia = 0, pasePorteroEspania = 0;
        Integer pasesItalia = 0, pasesEspania = 0;
        Double posesionesEspania = 0.0, posesionesItalia = 0.0;
        String equipo = "";
        try 
        {
            file = new File("3795220.json");
            file2 = new File("eventos.json");
            fileContent = FileUtils.readFileToString(file, EventsStatBomb.ENCODE);
            inputData = new ArrayList<DataInput>();
            input = new DataInput();
            JsonNode eventsJsonNode = Json.mapper().readTree(fileContent);
            if(eventsJsonNode.isArray())
            {
                JsonNode eventsArrayNode = (ArrayNode) eventsJsonNode;

                final Iterator<JsonNode> eventsIterator = eventsArrayNode.elements();

                while(eventsIterator.hasNext())
                {
                    final JsonNode eventsDataJsonNode = eventsIterator.next();
                    if(eventsDataJsonNode.has("minute"))
                    {
                        final JsonNode minuteNode = eventsDataJsonNode.get("minute");
                        input.setMinute(Integer.parseInt(minuteNode.asText()));
                    }
                    if(eventsDataJsonNode.has("second"))
                    {
                        final JsonNode secondNode = eventsDataJsonNode.get("second");
                        input.setSecond(Integer.parseInt(secondNode.asText()));
                    }
                    if(eventsDataJsonNode.has("possession_team"))
                    {
                        PossessionTeam possessionTeam = null;
                        JsonNode possessionTeamNode = eventsDataJsonNode.get("possession_team");
                        if(possessionTeamNode.isObject())
                        {
                            possessionTeam = new PossessionTeam();
                            JsonNode possessionTeamObjectNode = (ObjectNode) possessionTeamNode;
                            if(possessionTeamObjectNode.has("name"))
                            {
                                final JsonNode nameNode = possessionTeamObjectNode.get("name");
                                possessionTeam.setName(nameNode.asText());
                            }
                        }
                        input.setPossession_team(possessionTeam);
                    }
                    if(eventsDataJsonNode.has("team"))
                    {
                        Team team = null;
                        JsonNode teamNode = eventsDataJsonNode.get("team");
                        if(teamNode.isObject())
                        {
                            team = new Team();
                            JsonNode teamObjectNode = (ObjectNode) teamNode;
                            if(teamObjectNode.has("name"))
                            {
                                final JsonNode nameNode = teamObjectNode.get("name");
                                equipo = nameNode.asText();
                                team.setName(nameNode.asText());
                            }
                        }
                        input.setTeam(team);
                    }
                    if(eventsDataJsonNode.has("player"))
                    {
                        Player player = null;
                        JsonNode playerNode = eventsDataJsonNode.get("player");
                        if(playerNode.isObject())
                        {
                            player = new Player();
                            JsonNode playerObjectNode = (ObjectNode) playerNode;
                            if(playerObjectNode.has("name"))
                            {
                                final JsonNode nameNode = playerObjectNode.get("name");
                                player.setName(nameNode.asText());
                            }
                        }
                        input.setPlayer(player);
                    }
                    if(eventsDataJsonNode.has("shot"))
                    {
                        JsonNode shotNode = eventsDataJsonNode.get("shot");
                        if(shotNode.isObject())
                        {
                            Shot shot = new Shot();
                            JsonNode shotObjectNode = (ObjectNode) shotNode;
                            if(shotObjectNode.has("outcome"))
                            {
                                JsonNode outcomeNode = shotObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    Outcome outcome = new Outcome();
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                    shot.setOutcome(outcome);
                                }
                            }
                            input.setShot(shot);
                        }
                    }
                    if(eventsDataJsonNode.has("goalkeeper"))
                    {
                        if(equipo.equals("Italy"))
                        {
                            pasePorteroItalia++;
                        }
                        else if(equipo.equals("Spain"))
                        {
                            pasePorteroEspania++;
                        }
                    }
                    if(eventsDataJsonNode.has("pass"))
                    {
                        Pass pass = null;
                        JsonNode passNode = eventsDataJsonNode.get("pass");
                        if(passNode.isObject())
                        {
                            pass = new Pass();
                            JsonNode passObjectNode = (ObjectNode) passNode;
                            if(passObjectNode.has("recipient"))
                            {
                                Recipient recipient = null;
                                JsonNode recipientNode = passObjectNode.get("recipient");
                                if(recipientNode.isObject())
                                {
                                    recipient = new Recipient();
                                    JsonNode recipientObjectNode = (ObjectNode) recipientNode;
                                    if(recipientObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = recipientObjectNode.get("name");
                                        recipient.setName(nameNode.asText());
                                    }
                                    pass.setRecipient(recipient);
                                }
                            }
                            input.setPass(pass);
                        }
                    }
                    inputData.add(input);
                    
                }
            }
            outputData = new ArrayList<DataOutput>();
            output = new DataOutput();
            for(int i = 0; i < inputData.size(); i++)
            {
                if(inputData.get(i).getPossession_team().getName().equals("Spain"))
                {
                    posesionesEspania = posesionesEspania + 1.0;
                }
                else if(inputData.get(i).getPossession_team().getName().equals("Italy"))
                {
                    posesionesItalia = posesionesItalia + 1.0;
                }
                if(inputData.get(i).getMinute().equals(45) && inputData.get(i).getSecond().equals(2))
                {
                    primerTiempo = new PrimerTiempo();
                    Double porcentajePosesionEspania = 0.0, porcentajePosesionItalia = 0.0;
                    porcentajePosesionEspania = ((posesionesEspania/posesionesItalia)*100.0);
                    porcentajePosesionItalia = 100.0 - porcentajePosesionEspania;
                    primerTiempo.setEspania(porcentajePosesionEspania);
                    primerTiempo.setItalia(porcentajePosesionItalia);
                    posesionesEspania = 0.0;
                    posesionesItalia = 0.0;
                }
                if(inputData.get(i).getMinute().equals(90) && inputData.get(i).getSecond().equals(48))
                {
                    segundoTiempo = new SegundoTiempo();
                    Double porcentajePosesionEspania = 0.0, porcentajePosesionItalia = 0.0;
                    porcentajePosesionEspania = ((posesionesEspania/posesionesItalia)*100.0);
                    porcentajePosesionItalia = 100.0 - porcentajePosesionEspania;
                    segundoTiempo.setEspania(porcentajePosesionEspania);
                    segundoTiempo.setItalia(porcentajePosesionItalia);
                    partidoCompleto = new PartidoCompleto();
                    partidoCompleto.setEspania((primerTiempo.getEspania()+segundoTiempo.getEspania())/2);
                    partidoCompleto.setItalia((primerTiempo.getItalia()+segundoTiempo.getItalia())/2);
                    porcentajesPosesion = new PorcentajesPosesion();
                    porcentajesPosesion.setPrimer_tiempo(primerTiempo);
                    porcentajesPosesion.setSegundo_tiempo(segundoTiempo);
                    porcentajesPosesion.setPartido_completo(partidoCompleto);
                    output.setPorcentajes_posesion(porcentajesPosesion);
                }
                if(inputData.get(i).getShot().getOutcome().getName().equals("Goal"))
                {
                    goleador = new Goleador();
                    goleador.setMinuto(inputData.get(i).getMinute());
                    goleador.setSegundo(inputData.get(i).getSecond());
                    goleador.setEquipo(inputData.get(i).getPossession_team().getName());
                    goleador.setNombre(inputData.get(i).getPlayer().getName());
                    output.setGoleador(goleador);
                }
                if(inputData.get(i).getPass().getRecipient().getName().equals("Pedro González López"))
                {
                    pasesEspania++;
                }
                else if(inputData.get(i).getPass().getRecipient().getName().equals("Leonardo Bonucci"))
                {
                    pasesItalia++;
                }
            }
            porteroJugador = new PorteroJugador();
            if(pasePorteroEspania > pasePorteroItalia)
            {
                porteroJugador.setEquipo("Espania");
                porteroJugador.setNombre("Unai Simon");
                porteroJugador.setPases(pasePorteroEspania);
            }
            else
            {
                porteroJugador.setEquipo("Italia");
                porteroJugador.setNombre("Donnaruma");
                porteroJugador.setPases(pasePorteroItalia);
            }
            output.setPortero_jugador(porteroJugador);
            referenciaEspania = new Referencia();
            referenciaItalia = new Referencia();
            referenciaEspania.setEquipo("Espania");
            referenciaEspania.setNombre("Pedri");
            referenciaEspania.setPases(pasesEspania);
            output.setReferenciaEs(referenciaEspania);
            referenciaItalia.setEquipo("Italia");
            referenciaItalia.setNombre("Bonucci");
            referenciaItalia.setPases(pasesItalia);
            output.setReferenciaIt(referenciaItalia);
            outputData.add(output);
            System.out.println(outputData);
            objectWriter = Json.mapper().writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(file2, outputData);
        } 
        catch (Exception jsonException) 
        {
            LOGGER.error("Error durante el proceso de lectura y escritura de JSON");
            throw new EventsError("El proceso se ha detenido inesperadamente debido a un error", jsonException);
        }
    }
}