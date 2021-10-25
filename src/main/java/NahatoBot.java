import dto.ObjectDto;
import dto.UserDetailDto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NahatoBot extends TelegramLongPollingBot{
    private static final HashMap<String, String> ODER_LIST = new HashMap<>();

    @Override
    public String getBotUsername() {
        return "It's Nahato BOT";
    }

    @Override
    public String getBotToken() {
        return "2097387899:AAEoS81GZkXmgBpQnLIRzJK8oY9T6lyT9g0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            Message getMessage = update.getMessage();

            if(getMessage.hasText()){
                String command = getMessage.getText();
                SendMessage message = new SendMessage();
                SendPhoto photo =  new SendPhoto();
                SendPoll poll = new SendPoll();
                message.setChatId(String.valueOf(update.getMessage().getChatId()));

                if(command.equals("/userdetail@Nahato_bot")){
                    message.setText(update.getMessage().getFrom().toString());
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if(command.equals("/com3mien@Nahato_bot")){
                    handlerRequestCom3Mien(message);
                } else if(command.equals("/list@Nahato_bot")){
                    handlerRequestList(message);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if(command.equals("/test@Nahato_bot")){
                    handlerRequestTest(message);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if(command.equals("/start@Nahato_bot")){
                    message.setText("U waked me up MASTER ?! \n Please hit /help to check all the command!");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if(command.equals("/help@Nahato_bot")) {
                    String helpStr = "";
                    message.setText(helpStr);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if(command.equals("/order@Nahato_bot")){
                    handlerRequestOrder(update, getMessage);
                }
            }
        }
        if (update.hasCallbackQuery()){
            Message callbackMessage = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setParseMode(ParseMode.MARKDOWN);
            sendMessage.setChatId(String.valueOf(callbackMessage.getChatId()));

            if(data.equals("menu1"))
                sendMessage.setText("com3mien");
            else if (data.equals("menu2"))
                sendMessage.setText("comngonmenau");
            else if(data.equals("cơm 3 miền")) {
                sendMessage.setText("cơm 3 miền callback");
            } else if(data.equals("test-22-10"))
                sendMessage.setText("test-22-10 callback");

            try {
                execute(sendMessage);
            } catch(TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    public void handlerRequestCom3Mien(SendMessage message){
        ObjectMapper mapper = new ObjectMapper();
        try {
//                        String filePath = "D:\\MyProject\\test-22-10.json";
//
//                        //using BufferedReader
//                        StringBuilder sb = new StringBuilder();
//                        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"))) {
//
//                            String cLine;
//                            while ((cLine = br.readLine()) != null) {
//                                sb.append(cLine).append("\n");
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        System.out.println("##### Use BufferedReader to read UTF-8 encoded data from a text file");
//                        System.out.println(sb.toString());
//                        DishesDto menuListDto = mapper.readValue(sb.toString(), DishesDto.class);
//                        message.setText("Tên món: " + menuListDto.getName()
//                                + "\n" + menuListDto.getDescription()
//                                + "\n" + menuListDto.getPrice().getText()
//                                + "\n" + menuListDto.getDiscountPrice().getText()
//                                + "\n" + menuListDto.getPhotoList().get(4).getValue()
//                        );

            String filePath = "D:\\MyProject\\Nahato_BOT\\src\\main\\resources\\menu\\cơm 3 miền.json";
            String listStr = "";
            //using BufferedReader
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"))) {

                String cLine;
                while ((cLine = br.readLine()) != null) {
                    sb.append(cLine).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("##### Use BufferedReader to read UTF-8 encoded data from a text file");
            System.out.println(sb.toString());
            ObjectDto menuListDto = mapper.readValue(sb.toString(), ObjectDto.class);
            for(int i=0; i < menuListDto.getReplyDto().getMenuInfosDto().size(); i++){
                for(int j=0; j < menuListDto.getReplyDto().getMenuInfosDto().get(i).getDishesDtoList().size(); j++){
                    listStr += "Tên món: " + menuListDto.getReplyDto().getMenuInfosDto().get(i).getDishesDtoList().get(j).getName() + "\n"
                            + "Description: " + menuListDto.getReplyDto().getMenuInfosDto().get(i).getDishesDtoList().get(j).getDescription() + "\n"
                            + "Original Price: " + menuListDto.getReplyDto().getMenuInfosDto().get(i).getDishesDtoList().get(j).getPrice().getText() + "\n"
                            + "Discount Price: " + menuListDto.getReplyDto().getMenuInfosDto().get(i).getDishesDtoList().get(j).getDiscountPrice().getText() + "\n"
                            + "Photos: " + menuListDto.getReplyDto().getMenuInfosDto().get(i).getDishesDtoList().get(j).getPhotoList().get(4).getValue() + "END." + "\n";
                }
            }
            Thread thread = new Thread();
            StringUtils stringUtils = new StringUtils();
            String[] splitStr = stringUtils.splitString(listStr);

            for (String subString : splitStr) {
                message.setText(stringUtils.filterTailString(subString));
                execute(message);
                thread.sleep(4000);
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void handlerRequestList(SendMessage message){
        File folder = new File("D:\\MyProject\\Nahato_BOT\\src\\main\\resources\\menu");
        File[] listOfFiles = folder.listFiles();
        String listFileName = "";
        StringUtils stringUtils = new StringUtils();

        //inlineKeyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                listFileName += i + ". " + stringUtils.filterJsonTail(listOfFiles[i].getName()) + "\n";
                rowInline.add(new InlineKeyboardButton(stringUtils.filterJsonTail(listOfFiles[i].getName()), null, stringUtils.filterJsonTail(listOfFiles[i].getName()), null, null, null, false, null));
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
                listFileName += i + ". " + stringUtils.filterJsonTail(listOfFiles[i].getName()) + "\n";
                rowInline.add(new InlineKeyboardButton(stringUtils.filterJsonTail(listOfFiles[i].getName()), null, stringUtils.filterJsonTail(listOfFiles[i].getName()), null, null, null, false, null));
            }
        }
        message.setText(listFileName);
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
    }

    public void handlerRequestTest(SendMessage message){
        JSONParser parser = new JSONParser();

        try {
            Object object = parser.parse(new FileReader("D:\\MyProject\\test.json"));
            JSONObject jsonObject = (JSONObject) object;
            String name = (String) jsonObject.get("name");
            message.setText(name);

            InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
            List < List < InlineKeyboardButton >> rowsInline = new ArrayList < > ();
            List < InlineKeyboardButton > rowInline = new ArrayList < > ();
//                rowInline.add(new InlineKeyboardButton().setText("Open Browser").setUrl("https://www.google.com/"));
            rowInline.add(new InlineKeyboardButton("Menu1", null, "menu1", null, null, null, false, null));
            rowInline.add(new InlineKeyboardButton("Menu2", null, "menu2", null, null, null, false, null));
            rowsInline.add(rowInline);
            markupInline.setKeyboard(rowsInline);
            message.setReplyMarkup(markupInline);

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ParseException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void handlerRequestOrder(Update update, Message getMessage) {
        SendMessage orderMsg = new SendMessage();
        ODER_LIST.put(getMessage.getText(), getMessage.getFrom().toString());
        orderMsg.setChatId(String.valueOf(update.getMessage().getChatId()));
        orderMsg.setText("already ordered");
        System.out.println(ODER_LIST.size());
        System.out.println(ODER_LIST.toString());
        try {
            execute(orderMsg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
