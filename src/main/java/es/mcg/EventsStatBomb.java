package es.mcg;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectWriter;

import es.mcg.errors.EventsError;
import es.mcg.input.data.BallReceipt;
import es.mcg.input.data.BallRecovery;
import es.mcg.input.data.Block;
import es.mcg.input.data.BodyPart;
import es.mcg.input.data.Card;
import es.mcg.input.data.Clearance;
import es.mcg.input.data.Dribble;
import es.mcg.input.data.Duel;
import es.mcg.input.data.EventsData;
import es.mcg.input.data.FoulCommitted;
import es.mcg.input.data.FoulWon;
import es.mcg.input.data.FreezeFrame;
import es.mcg.input.data.Height;
import es.mcg.input.data.InjuryStoppage;
import es.mcg.input.data.Interception;
import es.mcg.input.data.Lineup;
import es.mcg.input.data.Outcome;
import es.mcg.input.data.Pass;
import es.mcg.input.data.PlayPattern;
import es.mcg.input.data.Player;
import es.mcg.input.data.Position;
import es.mcg.input.data.PossessionTeam;
import es.mcg.input.data.Recipient;
import es.mcg.input.data.Shot;
import es.mcg.input.data.Tactics;
import es.mcg.input.data.Team;
import es.mcg.input.data.Technique;
import es.mcg.input.data.Type;
import es.mcg.output.data.DataOutput;
import es.mcg.utils.Json;

public class EventsStatBomb {
    private static final String ENCODE = "UTF-8";
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws EventsError{
        List<DataOutput> datosSalida = null;
        List<EventsData> datosEntrada = null;
        File file = null;
        ObjectWriter objectWriter = null;
        String fileContent;

        try 
        {
            file = new File("3795220.json");
            fileContent = FileUtils.readFileToString(file, EventsStatBomb.ENCODE);
            objectWriter = Json.mapper().writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(new File("eventos.json"), datosSalida);
            datosSalida = new ArrayList<DataOutput>();
            datosEntrada = new ArrayList<EventsData>();
            JsonNode datosEntradaJsonNode = Json.mapper().readTree(fileContent);

            if(datosEntradaJsonNode.isArray())
            {
                JsonNode entradaArrayJsonNode = (ArrayNode) datosEntradaJsonNode;
                
                final Iterator<JsonNode> entradaIterator = entradaArrayJsonNode.elements();
                while(entradaIterator.hasNext())
                {
                    EventsData eventsData = new EventsData();
                    final JsonNode eventsDataJsonNode = entradaIterator.next();
                    if(eventsDataJsonNode.has("id"))
                    {
                        final JsonNode idNode = eventsDataJsonNode.get("id");
                        eventsData.setId(idNode.asText());
                    }
                    if(eventsDataJsonNode.has("index"))
                    {
                        final JsonNode indexNode = eventsDataJsonNode.get("index");
                        eventsData.setIndex(Integer.parseInt(indexNode.asText()));
                    }
                    if(eventsDataJsonNode.has("period"))
                    {
                        final JsonNode periodNode = eventsDataJsonNode.get("period");
                        eventsData.setPeriod(Integer.parseInt(periodNode.asText()));
                    }
                    if(eventsDataJsonNode.has("timestamp"))
                    {
                        final JsonNode timestampNode = eventsDataJsonNode.get("timestamp");
                        String pattern = "HH:mm:ss.SSS";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                        eventsData.setTimestamp(dateFormat.parse(timestampNode.asText())); 
                    }
                    if(eventsDataJsonNode.has("minute"))
                    {
                        final JsonNode minuteNode = eventsDataJsonNode.get("minute");
                        eventsData.setMinute(Integer.parseInt(minuteNode.asText()));
                    }
                    if(eventsDataJsonNode.has("second"))
                    {
                        final JsonNode secondNode = eventsDataJsonNode.get("second");
                        eventsData.setSecond(Integer.parseInt(secondNode.asText()));
                    }
                    if(eventsDataJsonNode.has("type"))
                    {
                        Type type = new Type();
                        JsonNode typeNode = eventsDataJsonNode.get("type");
                        if(typeNode.isObject())
                        {
                            JsonNode typeObjectNode = (ObjectNode) typeNode;
                            if(typeObjectNode.has("id"))
                            {
                                final JsonNode idNode = typeObjectNode.get("id");
                                type.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(typeObjectNode.has("name"))
                            {
                                final JsonNode nameNode = typeObjectNode.get("name");
                                type.setName(nameNode.asText());
                            }
                        }
                        eventsData.setType(type);
                    }
                    if(eventsDataJsonNode.has("possession"))
                    {
                        final JsonNode possessionNode = eventsDataJsonNode.get("possession");
                        eventsData.setPossession(Integer.parseInt(possessionNode.asText()));
                    }
                    if(eventsDataJsonNode.has("possession_team"))
                    {
                        PossessionTeam possessionTeam = new PossessionTeam();
                        JsonNode possessionTeamNode = eventsDataJsonNode.get("possession_team");
                        if(possessionTeamNode.isObject())
                        {
                            JsonNode possessionObjectNode = (ObjectNode) possessionTeamNode;

                            if(possessionObjectNode.has("id"))
                            {
                                final JsonNode idNode = possessionObjectNode.get("id");
                                possessionTeam.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(possessionObjectNode.has("name"))
                            {
                                final JsonNode nameNode = possessionObjectNode.get("name");
                                possessionTeam.setName(nameNode.asText());
                            }
                        }
                        eventsData.setPossession_team(possessionTeam);
                    }
                    if(eventsDataJsonNode.has("play_pattern"))
                    {
                        PlayPattern playPattern = new PlayPattern();
                        JsonNode playPatternNode = eventsDataJsonNode.get("play_pattern");
                        if(playPatternNode.isObject())
                        {
                            JsonNode patternObjectNode = (ObjectNode) playPatternNode;

                            if(patternObjectNode.has("id"))
                            {
                                final JsonNode idNode = patternObjectNode.get("id");
                                playPattern.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(patternObjectNode.has("name"))
                            {
                                final JsonNode nameNode = patternObjectNode.get("name");
                                playPattern.setName(nameNode.asText());
                            }
                        }
                        eventsData.setPlay_pattern(playPattern);
                    }
                    if(eventsDataJsonNode.has("out"))
                    {
                        final JsonNode outNode = eventsDataJsonNode.get("out");
                        eventsData.setOut(Boolean.parseBoolean(outNode.asText()));
                    }
                    if(eventsDataJsonNode.has("team"))
                    {
                        Team team = new Team();
                        JsonNode teamNode = eventsDataJsonNode.get("team");
                        if(teamNode.isObject())
                        {
                            JsonNode teamObjectNode = (ObjectNode) teamNode;

                            if(teamObjectNode.has("id"))
                            {
                                final JsonNode idNode = teamObjectNode.get("id");
                                team.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(teamObjectNode.has("name"))
                            {
                                final JsonNode nameNode = teamObjectNode.get("name");
                                team.setName(nameNode.asText());
                            }
                        }
                        eventsData.setTeam(team);
                    }
                    if(eventsDataJsonNode.has("player"))
                    {
                        Player player = new Player();
                        JsonNode playerNode = eventsDataJsonNode.get("player");

                        if(playerNode.isObject())
                        {
                            JsonNode playerObjectNode = (ObjectNode) playerNode;

                            if(playerObjectNode.has("id"))
                            {
                                final JsonNode idNode = playerObjectNode.get("id");
                                player.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(playerObjectNode.has("name"))
                            {
                                final JsonNode nameNode = playerObjectNode.get("name");
                                player.setName(nameNode.asText());
                            }
                        }
                        eventsData.setPlayer(player);
                    }
                    if(eventsDataJsonNode.has("position"))
                    {
                        Position position = new Position();
                        JsonNode positionNode = eventsDataJsonNode.get("position");

                        if(positionNode.isObject())
                        {
                            JsonNode positionObjectNode = (ObjectNode) positionNode;
                            if(positionObjectNode.has("id"))
                            {
                                final JsonNode idNode = positionObjectNode.get("id");
                                position.setId(Integer.parseInt(idNode.asText()));
                            }
                            if(positionObjectNode.has("name"))
                            {
                                final JsonNode nameNode = positionObjectNode.get("name");
                                position.setName(nameNode.asText());
                            }
                        }
                        eventsData.setPosition(position);
                    }
                    if(eventsDataJsonNode.has("duration"))
                    {
                        final JsonNode durationNode = eventsDataJsonNode.get("duration");
                        eventsData.setDuration(Double.parseDouble(durationNode.asText()));
                    }
                    if(eventsDataJsonNode.has("tactics"))
                    {
                        Tactics tactics = new Tactics();
                        JsonNode tacticsNode = eventsDataJsonNode.get("tactics");
                        if(tacticsNode.isObject())
                        {
                            JsonNode tacticsObjectNode = (ObjectNode) tacticsNode;

                            if(tacticsObjectNode.has("formation"))
                            {
                                final JsonNode formationNode = tacticsObjectNode.get("formation");
                                tactics.setFormation(Integer.parseInt(formationNode.asText()));
                            }
                            if(tacticsObjectNode.has("lineup"))
                            {
                                Lineup lineup = null;
                                JsonNode lineupNode = eventsDataJsonNode.get("lineup");

                                if(lineupNode.isArray())
                                {
                                    JsonNode lineupArrayNode = (ArrayNode) lineupNode;
                                    final Iterator<JsonNode> lineupIterator = lineupArrayNode.elements();

                                    while(lineupIterator.hasNext())
                                    {
                                        lineup = new Lineup();

                                        final JsonNode lineupJsonNode = lineupIterator.next();
                                        if(lineupJsonNode.has("player"))
                                        {
                                            Player player = new Player();

                                            JsonNode playerNode = lineupJsonNode.get("player");
                                            if(playerNode.isObject())
                                            {
                                                JsonNode playerObjectNode = (ObjectNode) playerNode;

                                                if(playerObjectNode.has("id"))
                                                {
                                                    final JsonNode idNode = playerObjectNode.get("id");
                                                    player.setId(Integer.parseInt(idNode.asText()));
                                                }
                                                if(playerObjectNode.has("name"))
                                                {
                                                    final JsonNode nameNode = playerObjectNode.get("name");
                                                    player.setName(nameNode.asText());
                                                }
                                            }
                                            lineup.setPlayer(player);
                                        }
                                        if(lineupJsonNode.has("position"))
                                        {
                                            Position position = new Position();

                                            JsonNode positionNode = lineupJsonNode.get("position");
                                            if(positionNode.isObject())
                                            {
                                                JsonNode positionObjectNode = (ObjectNode) positionNode;

                                                if(positionObjectNode.has("id"))
                                                {
                                                    final JsonNode idNode = positionObjectNode.get("id");
                                                    position.setId(Integer.parseInt(idNode.asText()));
                                                }
                                                if(positionObjectNode.has("name"))
                                                {
                                                    final JsonNode nameNode = positionObjectNode.get("name");
                                                    position.setName(nameNode.asText());
                                                }
                                            }
                                            lineup.setPosition(position);
                                        }
                                        if(lineupJsonNode.has("jersey_number"))
                                        {
                                            final JsonNode jerseyNumberNode = lineupJsonNode.get("jersey_number");
                                            lineup.setJersey_number(Integer.parseInt(jerseyNumberNode.asText()));
                                        }
                                    }
                                }
                                tactics.setLineup(lineup);
                            }
                        }
                        eventsData.setTactics(tactics);
                    }
                    if(eventsDataJsonNode.has("under_pressure"))
                    {
                        final JsonNode underPressureNode = eventsDataJsonNode.get("under_pressure");
                        eventsData.setUnder_pressure(Boolean.parseBoolean(underPressureNode.asText()));
                    }
                    if(eventsDataJsonNode.has("counterpress"))
                    {
                        final JsonNode counterpressNode = eventsDataJsonNode.get("counterpress");
                        eventsData.setCounterpress(Boolean.parseBoolean(counterpressNode.asText()));
                    }
                    if(eventsDataJsonNode.has("dribble"))
                    {
                        Dribble dribble = new Dribble();

                        JsonNode dribbleNode = eventsDataJsonNode.get("dribble");
                        if(dribbleNode.isObject())
                        {
                            JsonNode dribbleObjectNode = (ObjectNode) dribbleNode;

                            if(dribbleObjectNode.has("nutmeg"))
                            {
                                final JsonNode nutmegNode = dribbleObjectNode.get("nutmeg");
                                dribble.setNutmeg(Boolean.parseBoolean(nutmegNode.asText()));
                            }
                            if(dribbleObjectNode.has("outcome"))
                            {
                                Outcome outcome = new Outcome();

                                JsonNode outcomeNode = dribbleObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;

                                    if(outcomeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = outcomeObjectNode.get("id");
                                        outcome.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                }
                                dribble.setOutcome(outcome);
                            }
                            if(dribbleObjectNode.has("overrun"))
                            {
                                final JsonNode overrunNode = dribbleObjectNode.get("overrun");
                                dribble.setOverrun(Boolean.parseBoolean(overrunNode.asText()));
                            }
                        }
                        eventsData.setDribble(dribble);
                    }
                    if(eventsDataJsonNode.has("ball_receipt"))
                    {
                        BallReceipt ballReceipt = new BallReceipt();

                        JsonNode ballReceiptNode = eventsDataJsonNode.get("ball_receipt");
                        if(ballReceiptNode.isObject())
                        {
                            JsonNode ballReceiptObjectNode = (ObjectNode) ballReceiptNode;

                            if(ballReceiptObjectNode.has("outcome"))
                            {
                                Outcome outcome = new Outcome();

                                JsonNode outcomeNode = ballReceiptObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;

                                    if(outcomeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = outcomeObjectNode.get("id");
                                        outcome.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                }
                                ballReceipt.setOutcome(outcome);
                            }
                        }
                        eventsData.setBall_receipt(ballReceipt);
                    }
                    if(eventsDataJsonNode.has("ball_recovery"))
                    {
                        BallRecovery ballRecovery = new BallRecovery();

                        JsonNode ballRecoveryNode = eventsDataJsonNode.get("ball_recovery");
                        if(ballRecoveryNode.isObject())
                        {
                            JsonNode ballRecoveryObjectNode = (ObjectNode) ballRecoveryNode;

                            if(ballRecoveryObjectNode.has("recovery_failure"))
                            {
                                final JsonNode recoveryFailureNode = ballRecoveryObjectNode.get("recovery_failure");
                                ballRecovery.setRecovery_failure(Boolean.parseBoolean(recoveryFailureNode.asText()));
                            }
                        }
                        eventsData.setBall_recovery(ballRecovery);
                    }
                    if(eventsDataJsonNode.has("pass"))
                    {
                        Pass pass = new Pass();

                        JsonNode passNode = eventsDataJsonNode.get("pass");
                        if(passNode.isObject())
                        {
                            JsonNode passObjectNode = (ObjectNode) passNode;

                            if(passObjectNode.has("recipient"))
                            {
                                Recipient recipient = new Recipient();

                                JsonNode recipientNode = passObjectNode.get("recipient");
                                if(recipientNode.isObject())
                                {
                                    JsonNode recipientObjectNode = (ObjectNode) recipientNode;

                                    if(recipientObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = recipientObjectNode.get("id");
                                        recipient.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(recipientObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = recipientObjectNode.get("name");
                                        recipient.setName(nameNode.asText());
                                    }
                                }
                                pass.setRecipient(recipient);
                            }
                            if(passObjectNode.has("length"))
                            {
                                final JsonNode lengthNode = passObjectNode.get("length");
                                pass.setLength(Double.parseDouble(lengthNode.asText()));
                            }
                            if(passObjectNode.has("angle"))
                            {
                                final JsonNode angleNode = passObjectNode.get("angle");
                                pass.setAngle(Double.parseDouble(angleNode.asText()));
                            }
                            if(passObjectNode.has("height"))
                            {
                                Height height = new Height();

                                JsonNode heightNode = passObjectNode.get("height");
                                if(heightNode.isObject())
                                {
                                    JsonNode heightObjectNode = (ObjectNode) heightNode;

                                    if(heightObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = heightObjectNode.get("id");
                                        height.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(heightObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = heightObjectNode.get("name");
                                        height.setName(nameNode.asText());
                                    }
                                }
                                pass.setHeight(height);
                            }
                            if(passObjectNode.has("switch"))
                            {
                                final JsonNode switchNode = passObjectNode.get("switch");
                                pass.setSwitchParam(Boolean.parseBoolean(switchNode.asText()));
                            }
                            if(passObjectNode.has("no_touch"))
                            {
                                final JsonNode noTouchNode = passObjectNode.get("no_touch");
                                pass.setNo_touch(Boolean.parseBoolean(noTouchNode.asText()));
                            }
                            if(passObjectNode.has("cross"))
                            {
                                final JsonNode crossNode = passObjectNode.get("cross");
                                pass.setCross(Boolean.parseBoolean(crossNode.asText()));
                            }
                            if(passObjectNode.has("cut_back"))
                            {
                                final JsonNode cutBackNode = passObjectNode.get("cut_back");
                                pass.setCut_back(Boolean.parseBoolean(cutBackNode.asText()));
                            }
                            if(passObjectNode.has("assisted_shot_id"))
                            {
                                final JsonNode assistedShotIdNode = passObjectNode.get("assisted_shot_id");
                                pass.setAssisted_shot_id(assistedShotIdNode.asText());
                            }
                            if(passObjectNode.has("shot_assist"))
                            {
                                final JsonNode shotAssistNode = passObjectNode.get("shot_assist");
                                pass.setShot_assist(Boolean.parseBoolean(shotAssistNode.asText()));
                            }
                            if(passObjectNode.has("outcome"))
                            {
                                Outcome outcome = new Outcome();

                                JsonNode outcomeNode = passObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;

                                    if(outcomeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = outcomeObjectNode.get("id");
                                        outcome.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                }
                                pass.setOutcome(outcome);
                            }
                            if(passObjectNode.has("type"))
                            {
                                Type type = new Type();

                                JsonNode typeNode = passObjectNode.get("type");
                                if(typeNode.isObject())
                                {
                                    JsonNode typeObjectNode = (ObjectNode) typeNode;

                                    if(typeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = typeObjectNode.get("id");
                                        type.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(typeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = typeObjectNode.get("name");
                                        type.setName(nameNode.asText());
                                    }
                                }
                                pass.setType(type);
                            }
                            if(passObjectNode.has("through_ball"))
                            {
                                final JsonNode throughBallNode = passObjectNode.get("through_ball");
                                pass.setThrough_ball(Boolean.parseBoolean(throughBallNode.asText()));
                            }
                            if(passObjectNode.has("inswinging"))
                            {
                                final JsonNode inswingingNode = passObjectNode.get("inswinging");
                                pass.setInswinging(Boolean.parseBoolean(inswingingNode.asText()));
                            }
                            if(passObjectNode.has("outswinging"))
                            {
                                final JsonNode outswingingNode = passObjectNode.get("inswinging");
                                pass.setInswinging(Boolean.parseBoolean(outswingingNode.asText()));
                            }
                            if(passObjectNode.has("technique"))
                            {
                                Technique technique = new Technique();

                                JsonNode techniqueNode = passObjectNode.get("technique");
                                if(techniqueNode.isObject())
                                {
                                    JsonNode techniqueObjectNode = (ObjectNode) techniqueNode;

                                    if(techniqueObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = techniqueObjectNode.get("id");
                                        technique.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(techniqueObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = techniqueObjectNode.get("name");
                                        technique.setName(nameNode.asText());
                                    }
                                }
                                pass.setTechnique(technique);
                            }
                            if(passObjectNode.has("body_part"))
                            {
                                BodyPart bodyPart = new BodyPart();

                                JsonNode bodyPartNode = passObjectNode.get("body_part");
                                if(bodyPartNode.isObject())
                                {
                                    JsonNode bodyPartObjectNode = (ObjectNode) bodyPartNode;
                                    if(bodyPartObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = bodyPartObjectNode.get("id");
                                        bodyPart.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(bodyPartObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = bodyPartObjectNode.get("name");
                                        bodyPart.setName(nameNode.asText());
                                    }
                                }
                                pass.setBody_part(bodyPart);
                            }
                            if(passObjectNode.has("aerial_won"))
                            {
                                final JsonNode aerialWonNode = passObjectNode.get("aerial_won");
                                pass.setAerial_won(Boolean.parseBoolean(aerialWonNode.asText()));
                            }
                        }
                        eventsData.setPass(pass);
                    }
                    if(eventsDataJsonNode.has("clearance"))
                    {
                        Clearance clearance = new Clearance();

                        JsonNode clearanceNode = eventsDataJsonNode.get("clearance");
                        if(clearanceNode.isObject())
                        {
                            JsonNode clearanceObjectNode = (ObjectNode) clearanceNode;
                            if(clearanceObjectNode.has("head"))
                            {
                                final JsonNode headNode = clearanceObjectNode.get("head");
                                clearance.setHead(Boolean.parseBoolean(headNode.asText()));
                            }
                            if(clearanceObjectNode.has("left_foot"))
                            {
                                final JsonNode leftFootNode = clearanceObjectNode.get("left_foot");
                                clearance.setLeft_foot(Boolean.parseBoolean(leftFootNode.asText()));
                            }
                            if(clearanceObjectNode.has("right_foot"))
                            {
                                final JsonNode rightFootNode = clearanceObjectNode.get("right_foot");
                                clearance.setRight_foot(Boolean.parseBoolean(rightFootNode.asText()));
                            }
                            if(clearanceObjectNode.has("body_part"))
                            {
                                BodyPart bodyPart = new BodyPart();

                                JsonNode bodyPartNode = clearanceObjectNode.get("body_part");
                                if(bodyPartNode.isObject())
                                {
                                    JsonNode bodyPartObjectNode = (ObjectNode) bodyPartNode;
                                    if(bodyPartObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = bodyPartObjectNode.get("id");
                                        bodyPart.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(bodyPartObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = bodyPartObjectNode.get("name");
                                        bodyPart.setName(nameNode.asText());
                                    }
                                }
                                clearance.setBodyPart(bodyPart);
                            }
                            if(clearanceObjectNode.has("aerial_won"))
                            {
                                final JsonNode aerialWonNode = clearanceObjectNode.get("aerial_won");
                                clearance.setAerial_won(Boolean.parseBoolean(aerialWonNode.asText()));
                            }
                        }
                        eventsData.setClearance(clearance);
                    }
                    if(eventsDataJsonNode.has("interception"))
                    {
                        Interception interception = new Interception();

                        JsonNode interceptionNode = eventsDataJsonNode.get("interception");
                        if(interceptionNode.isObject())
                        {
                            JsonNode interceptionObjectNode = (ObjectNode) interceptionNode;
                            if(interceptionObjectNode.has("outcome"))
                            {
                                Outcome outcome = new Outcome();
                                JsonNode outcomeNode = interceptionObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;

                                    if(outcomeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = outcomeObjectNode.get("id");
                                        outcome.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                }
                                interception.setOutcome(outcome);
                            }
                        }
                        eventsData.setInterception(interception);
                    }
                    if(eventsDataJsonNode.has("block"))
                    {
                        Block block = new Block();

                        JsonNode blockNode = eventsDataJsonNode.get("block");
                        if(blockNode.isObject())
                        {
                            JsonNode blockObjectNode = (ObjectNode) blockNode;
                            if(blockObjectNode.has("offensive"))
                            {
                                final JsonNode offensiveNode = blockObjectNode.get("offensive");
                                block.setOffensive(Boolean.parseBoolean(offensiveNode.asText()));
                            }
                        }
                        eventsData.setBlock(block);
                    }
                    if(eventsDataJsonNode.has("duel"))
                    {
                        Duel duel = new Duel();

                        JsonNode duelNode = eventsDataJsonNode.get("duel");
                        if(duelNode.isObject())
                        {
                            JsonNode duelObjectNode = (ObjectNode) duelNode;
                            if(duelObjectNode.has("outcome"))
                            {
                                Outcome outcome = new Outcome();

                                JsonNode outcomeNode = duelObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;

                                    if(outcomeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = outcomeObjectNode.get("id");
                                        outcome.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                }
                                duel.setOutcome(outcome);
                            }
                            if(duelObjectNode.has("type"))
                            {
                                Type type = new Type();

                                JsonNode typeNode = duelObjectNode.get("type");
                                if(typeNode.isObject())
                                {
                                    JsonNode typeObjectNode = (ObjectNode) typeNode;

                                    if(typeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = typeObjectNode.get("id");
                                        type.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(typeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = typeObjectNode.get("name");
                                        type.setName(nameNode.asText());
                                    }
                                }
                                duel.setType(type);
                            }
                        }
                        eventsData.setDuel(duel);
                    }
                    if(eventsDataJsonNode.has("foul_won"))
                    {
                        FoulWon foulWon = new FoulWon();

                        JsonNode foulWonNode = eventsDataJsonNode.get("foul_won");
                        if(foulWonNode.isObject())
                        {
                            JsonNode foulWonObjectNode = (ObjectNode) foulWonNode;
                            if(foulWonObjectNode.has("defensive"))
                            {
                                final JsonNode defensiveNode = foulWonObjectNode.get("defensive");
                                foulWon.setDefensive(Boolean.parseBoolean(defensiveNode.asText()));
                            }
                            if(foulWonObjectNode.has("advantage"))
                            {
                                final JsonNode advantageNode = foulWonObjectNode.get("advantage");
                                foulWon.setAdvantage(Boolean.parseBoolean(advantageNode.asText()));
                            }
                        }
                        eventsData.setFoul_won(foulWon);
                    }
                    if(eventsDataJsonNode.has("foul_committed"))
                    {
                        FoulCommitted foulCommitted = new FoulCommitted();

                        JsonNode foulCommittedNode = eventsDataJsonNode.get("foul_committed");
                        if(foulCommittedNode.isObject())
                        {
                            JsonNode foulCommitedObjectNode = (ObjectNode) foulCommittedNode;
                            if(foulCommitedObjectNode.has("advantage"))
                            {
                                final JsonNode advantageNode = foulCommitedObjectNode.get("advantage");
                                foulCommitted.setAdvantage(Boolean.parseBoolean(advantageNode.asText()));
                            }
                            if(foulCommitedObjectNode.has("card"))
                            {
                                Card card = new Card();

                                JsonNode cardNode = foulCommitedObjectNode.get("card");
                                if(cardNode.isObject())
                                {
                                    JsonNode cardObjectNode = (ObjectNode) cardNode;
                                    if(cardObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = cardObjectNode.get("id");
                                        card.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(cardObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = cardObjectNode.get("card");
                                        card.setName(nameNode.asText());
                                    }
                                }
                                foulCommitted.setCard(card);
                            }
                        }
                        eventsData.setFoul_committed(foulCommitted);
                    }
                    if(eventsDataJsonNode.has("injury_stoppage"))
                    {
                        InjuryStoppage injuryStoppage = new InjuryStoppage();

                        JsonNode stoppageNode = eventsDataJsonNode.get("injury_stoppage");
                        if(stoppageNode.isObject())
                        {
                            JsonNode stoppageObjectNode = (ObjectNode) stoppageNode;
                            if(stoppageObjectNode.has("in_chain"))
                            {
                                final JsonNode chainNode = stoppageObjectNode.get("in_chain");
                                injuryStoppage.setIn_chain(Boolean.parseBoolean(chainNode.asText()));
                            }
                        }
                        eventsData.setInjury_stoppage(injuryStoppage);
                    }
                    if(eventsDataJsonNode.has("shot"))
                    {
                        Shot shot = new Shot();

                        JsonNode shotNode = eventsDataJsonNode.get("shot");
                        if(shotNode.isObject())
                        {
                            JsonNode shotObjectNode = (ObjectNode) shotNode;
                            if(shotObjectNode.has("one_on_one"))
                            {
                                final JsonNode oneOnOneNode = shotObjectNode.get("one_on_one");
                                shot.setOne_on_one(Boolean.parseBoolean(oneOnOneNode.asText()));
                            }
                            if(shotObjectNode.has("statsbomb_xg"))
                            {
                                final JsonNode statsbombXGNode = shotObjectNode.get("statsbomb_xg");
                                shot.setStatsbomb_xg(Double.parseDouble(statsbombXGNode.asText()));
                            }
                            if(shotObjectNode.has("key_pass_id"))
                            {
                                final JsonNode keyPassIDNode = shotObjectNode.get("key_pass_id");
                                shot.setKey_pass_id(keyPassIDNode.asText());
                            }
                            if(shotObjectNode.has("first_time"))
                            {
                                final JsonNode firstTimeNode = shotObjectNode.get("first_time");
                                shot.setFirst_time(Boolean.parseBoolean(firstTimeNode.asText()));
                            }
                            if(shotObjectNode.has("outcome"))
                            {
                                Outcome outcome = new Outcome();

                                JsonNode outcomeNode = shotObjectNode.get("outcome");
                                if(outcomeNode.isObject())
                                {
                                    JsonNode outcomeObjectNode = (ObjectNode) outcomeNode;

                                    if(outcomeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = outcomeObjectNode.get("id");
                                        outcome.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(outcomeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = outcomeObjectNode.get("name");
                                        outcome.setName(nameNode.asText());
                                    }
                                }
                                shot.setOutcome(outcome);
                            }
                            if(shotObjectNode.has("type"))
                            {
                                Type type = new Type();

                                JsonNode typeNode = shotObjectNode.get("tpye");
                                if(typeNode.isObject())
                                {
                                    JsonNode typeObjectNode = (ObjectNode) typeNode;

                                    if(typeObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = typeObjectNode.get("id");
                                        type.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(typeObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = typeObjectNode.get("name");
                                        type.setName(nameNode.asText());
                                    }
                                }
                                shot.setType(type);
                            }
                            if(shotObjectNode.has("body_part"))
                            {
                                BodyPart bodyPart = new BodyPart();

                                JsonNode bodyPartNode = shotObjectNode.get("body_part");
                                if(bodyPartNode.isObject())
                                {
                                    JsonNode bodyPartObjectNode = (ObjectNode) bodyPartNode;
                                    if(bodyPartObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = bodyPartObjectNode.get("id");
                                        bodyPart.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(bodyPartObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = bodyPartObjectNode.get("name");
                                        bodyPart.setName(nameNode.asText());
                                    }
                                }
                                shot.setBodyPart(bodyPart);
                            }
                            if(shotObjectNode.has("technique"))
                            {
                                Technique technique = new Technique();

                                JsonNode techniqueNode = shotObjectNode.get("technique");
                                if(techniqueNode.isObject())
                                {
                                    JsonNode techniqueObjectNode = (ObjectNode) techniqueNode;

                                    if(techniqueObjectNode.has("id"))
                                    {
                                        final JsonNode idNode = techniqueObjectNode.get("id");
                                        technique.setId(Integer.parseInt(idNode.asText()));
                                    }
                                    if(techniqueObjectNode.has("name"))
                                    {
                                        final JsonNode nameNode = techniqueObjectNode.get("name");
                                        technique.setName(nameNode.asText());
                                    }
                                }
                                shot.setTechnique(technique);
                            }
                            if(shotObjectNode.has("freeze_frame"))
                            {
                                FreezeFrame freezeFrame = null;

                                JsonNode freezeFrameNode = shotObjectNode.get("freeze_frame");
                                if(freezeFrameNode.isArray())
                                {
                                    JsonNode freezeFrameArrayNode = (ArrayNode) freezeFrameNode;

                                    final Iterator<JsonNode> freezeFrameIterator = freezeFrameArrayNode.elements();
                                    while(freezeFrameIterator.hasNext())
                                    {
                                        freezeFrame = new FreezeFrame();
                                        final JsonNode freezeFrameDataJsonNode = freezeFrameIterator.next();
                                        if(freezeFrameDataJsonNode.has("player"))
                                        {
                                            Player player = new Player();

                                            JsonNode playerNode = freezeFrameDataJsonNode.get("player");
                                            if(playerNode.isObject())
                                            {
                                                JsonNode playerObjectNode = (ObjectNode) playerNode;

                                                if(playerObjectNode.has("id"))
                                                {
                                                    final JsonNode idNode = playerObjectNode.get("id");
                                                    player.setId(Integer.parseInt(idNode.asText()));
                                                }
                                                if(playerObjectNode.has("name"))
                                                {
                                                    final JsonNode nameNode = playerObjectNode.get("name");
                                                    player.setName(nameNode.asText());
                                                }
                                            }
                                            freezeFrame.setPlayer(player);
                                        }
                                        if(freezeFrameDataJsonNode.has("position"))
                                        {
                                            Position position = new Position();

                                            JsonNode positionNode = freezeFrameDataJsonNode.get("position");
                                            if(positionNode.isObject())
                                            {
                                                JsonNode positionObjectNode = (ObjectNode) positionNode;
                                                if(positionObjectNode.has("id"))
                                                {
                                                    final JsonNode idNode = positionObjectNode.get("id");
                                                    position.setId(Integer.parseInt(idNode.asText()));
                                                }
                                                if(positionObjectNode.has("name"))
                                                {
                                                    final JsonNode nameNode = positionObjectNode.get("name");
                                                    position.setName(nameNode.asText());
                                                }
                                            }
                                            freezeFrame.setPosition(position);
                                        }
                                        if(freezeFrameDataJsonNode.has("teammate"))
                                        {
                                            final JsonNode teammateNode = freezeFrameDataJsonNode.get("teammate");
                                            freezeFrame.setTeammate(Boolean.parseBoolean(teammateNode.asText()));
                                        }
                                    }
                                }
                                shot.setFreeze_frame(freezeFrame);
                            }
                        }
                        eventsData.setShot(shot);
                    }
                    datosEntrada.add(eventsData);
                }
            }
            objectWriter = Json.mapper().writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(new File("eventos.json"), datosSalida);
        }
        catch (IOException | ParseException jsonException) 
        {
            LOGGER.error("Error durante la ejecucion de lectura y escritura de los ficheros JSON");
            throw new EventsError("El proceso se ha detenido inesperadamente debido a un error", jsonException);
        }
    }
}
