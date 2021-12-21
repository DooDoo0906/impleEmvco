import decoder.mpm.DecoderMpm;
import model.mpm.*;

public class testQr {
    public static void main(String[] args) {
        String encoded=
                "00020101021126300010A0000007750112000000000311" +
                        "5204123453037045802VN5909minhan3116003HCM6106" +
                        "70000062200307DT3110107053110163047B1D";
        MerchantPresentedMode merchantInfo = DecoderMpm.decode(encoded, MerchantPresentedMode.class);
        MerchantAccountInformationTemplate merchantAccountInformationTemplate= merchantInfo.getMerchantAccountInformation().get("26");
        MerchantAccountInformation merchantAccountInformation= merchantAccountInformationTemplate.getValue();
        MerchantAccountInformationReservedAdditional merchantAccountInformationReservedAdditional= (MerchantAccountInformationReservedAdditional) merchantAccountInformation;

        System.out.println("Payload Format Indicator: "+ merchantInfo.getPayloadFormatIndicator());
        System.out.println("Point of initiation: "+ merchantInfo.getPointOfInitiationMethod());
        System.out.println("Merchant Account Information: "+merchantInfo.getMerchantAccountInformation());
        System.out.println("+Globally Unique Identifier: "+merchantAccountInformationReservedAdditional.getGloballyUniqueIdentifier());
        System.out.println("Merchant Category Code: "+merchantInfo.getMerchantCategoryCode());
        System.out.println("Transaction Amount: "+ merchantInfo.getTransactionAmount());
        System.out.println("Transaction Currency Code: "+merchantInfo.getTransactionCurrency());
        System.out.println("Country Code: "+merchantInfo.getCountryCode());
        System.out.println("Merchant Name: "+merchantInfo.getMerchantName());
        System.out.println("Merchant City: "+merchantInfo.getMerchantCity());
        System.out.println("Postal Code: "+ merchantInfo.getPostalCode());
        System.out.println("Additional Data Field: "+merchantInfo.getAdditionalDataField());
        System.out.println("+Bill number: " + merchantInfo.getAdditionalDataField().getValue().getBillNumber());
        System.out.println("+Store Label: "+ merchantInfo.getAdditionalDataField().getValue().getStoreLabel());
        System.out.println("CRC:"+ merchantInfo.getCRC());
    }
}
