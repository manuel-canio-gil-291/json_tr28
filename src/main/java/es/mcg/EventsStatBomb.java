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
        List<Goleador> goleadores = null;
        List<Referencia> referencias = null;
        Referencia referenciaEspania = null, referenciaItalia = null;
        PorteroJugador porteroJugador = null;
        PorcentajesPosesion porcentajesPosesion = null;
        PrimerTiempo primerTiempo = null;
        SegundoTiempo segundoTiempo = null;
        PartidoCompleto partidoCompleto = null;
        Integer pasePorteroItalia = 0, pasePorteroEspania = 0;
        Integer pasesItalia = 0, pasesEspania = 0;
        Double posesionesEspania = 0.0, posesionesItalia = 0.0;
        Integer minute = 0, second = 0;
        String equipo = "", jugador = "";
        try 
        {
            file = new File("3795220.json");
            file2 = new File("eventos.json");
            fileContent = FileUtils.readFileToString(file, EventsStatBomb.ENCODE);
            goleadores = new ArrayList<Goleador>();
            referencias = new ArrayList<Referencia>();
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
                        minute = Integer.parseInt(minuteNode.asText());
                    }
                    if(eventsDataJsonNode.has("second"))
                    {
                        final JsonNode secondNode = eventsDataJsonNode.get("second");
                        second = Integer.parseInt(secondNode.asText());
                    }
                    if(eventsDataJsonNode.has("possession_team"))
                    {
                        JsonNode possessionTeamNode = eventsDataJsonNode.get("possession_team");
                        if(possessionTeamNode.isObject())
                        {
                            JsonNode possessionTeamObjectNode = (ObjectNode) possessionTeamNode;
                            if(possessionTeamObjectNode.has("name"))
                            {
                                final JsonNode nameNode = possessionTeamObjectNode.get("name");
                                if(nameNode.asText().equals("Spain"))
                                {
                                    posesionesEspania = posesionesEspania + 1.0;
                                }
                                else if(nameNode.asText().equals("Italy"))
                                {
                                    posesionesItalia = posesionesItalia + 1.0;
                                }
                            }
                        }
                    }
                    if(eventsDataJsonNode.has("team"))
                    {
                        JsonNode teamNode = eventsDataJsonNode.get("team");
                        if(teamNode.isObject())
                        {
                            JsonNode teamObjectNode = (ObjectNode) teamNode;
                            if(teamObjectNode.has("name"))
                            {
                                final JsonNode nameNode = teamObjectNode.get("name");
                                equipo = nameNode.asText();
                            }
                        }
                    }
                    if(eventsDataJsonNode.has("player"))
                    {
                        JsonNode playerNode = eventsDataJsonNode.get("player");
                        if(playerNode.isObject())
                        {
                            JsonNode playerObjectNode = (ObjectNode) playerNode;
                            if(playerObjectNode.has("name"))
                            {
                                final JsonNode nameNode = playerObjectNode.get("name");
                                jugador = nameNode.asText();
                            }
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
                    if(eventsDataJsonNode.has("shot"))
                    {
                        JsonNode shotNode = eventsDataJsonNode.get("shot");
                        if(shotNode.isObject())
                        {
                            JsonNode shotObjectNode = (ObjectNode) shotNode;
                            if(shotObjectNode.has("outcome"))
                            {
                                JsonNode outcomeNode = shotObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        Goleador goleador = new Goleador();
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        if(nameNode.asText().equals("Goal"))
                                        {
                                            goleador.setMinuto(minute);
                                            goleador.setSegundo(second);
                                            goleador.setEquipo(equipo);
                                            goleador.setNombre(jugador);
                                            goleadores.add(goleador);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(eventsDataJsonNode.has("pass"))
                    {
                        JsonNode passNode = eventsDataJsonNode.get("pass");
                        if(passNode.isObject())
                        {
                            JsonNode passObjectNode = (ObjectNode) passNode;
                            if(passObjectNode.has("recipient"))
                            {
                                JsonNode recipientNode = passObjectNode.get("recipient");
                                if(recipientNode.isObject())
                                {
                                    JsonNode recipientObjectNode = (ObjectNode) recipientNode;
                                    if(recipientObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = recipientObjectNode.get("name");
                                        if(nameNode.asText().equals("Pedro González López"))
                                        {
                                            pasesEspania++;
                                        }
                                        else if(nameNode.asText().equals("Leonardo Bonucci"))
                                        {
                                            pasesItalia++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(minute == 45 && second == 2)
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
                    if(minute == 90 && second == 48)
                    {
                        segundoTiempo = new SegundoTiempo();
                        Double porcentajePosesionEspania = 0.0, porcentajePosesionItalia = 0.0;
                        porcentajePosesionEspania = ((posesionesEspania/posesionesItalia)*100.0);
                        porcentajePosesionItalia = 100.0 - porcentajePosesionEspania;
                        segundoTiempo.setEspania(porcentajePosesionEspania);
                        segundoTiempo.setItalia(porcentajePosesionItalia);
                    }
                    partidoCompleto = new PartidoCompleto();
                    partidoCompleto.setEspania((primerTiempo.getEspania()+segundoTiempo.getEspania())/2);
                    partidoCompleto.setItalia((primerTiempo.getItalia()+segundoTiempo.getItalia())/2);
                    porcentajesPosesion = new PorcentajesPosesion(primerTiempo, segundoTiempo, partidoCompleto);
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
            referenciaEspania = new Referencia();
            referenciaItalia = new Referencia();
            referenciaEspania.setEquipo("Espania");
            referenciaEspania.setNombre("Pedri");
            referenciaEspania.setPases(pasesEspania);
            referencias.add(referenciaEspania);
            referenciaItalia.setEquipo("Italia");
            referenciaItalia.setNombre("Bonucci");
            referenciaItalia.setPases(pasesItalia);
            referencias.add(referenciaItalia);
            objectWriter = Json.mapper().writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(file2, goleadores);
            objectWriter.writeValue(file2, referencias);
            objectWriter.writeValue(file2, porteroJugador);
            objectWriter.writeValue(file2, porcentajesPosesion);
        } 
        catch (Exception jsonException) 
        {
            LOGGER.error("Error durante el proceso de lectura y escritura de JSON");
            throw new EventsError("El proceso se ha detenido inesperadamente debido a un error", jsonException);
        }
    }
}
