package core.configuration;

import core.model.mpm.TagLengthString;
import decoder.mpm.*;
import model.mpm.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DecodersMpmMap {

  private static final Map<Class<?>, Class<? extends DecoderMpm<?>>> MAP_DECODERS = new ConcurrentHashMap<>();

  static {
    MAP_DECODERS.put(String.class, StringDecoder.class);
    MAP_DECODERS.put(TagLengthString.class, TagLengthStringDecoder.class);
    MAP_DECODERS.put(MerchantPresentedMode.class, MerchantPresentedModeDecoder.class);
    MAP_DECODERS.put(AdditionalDataFieldTemplate.class, AdditionalDataFieldTemplateDecoder.class);
    MAP_DECODERS.put(AdditionalDataField.class, AdditionalDataFieldDecoder.class);
    MAP_DECODERS.put(MerchantInformationLanguageTemplate.class, MerchantInformationLanguageTemplateDecoder.class);
    MAP_DECODERS.put(MerchantInformationLanguage.class, MerchantInformationLanguageDecoder.class);
    MAP_DECODERS.put(MerchantAccountInformationTemplate.class, MerchantAccountInformationTemplateDecoder.class);
    MAP_DECODERS.put(MerchantAccountInformationReserved.class, MerchantAccountInformationReservedDecoder.class);
    MAP_DECODERS.put(MerchantAccountInformationReservedAdditional.class, MerchantAccountInformationReservedAdditionalDecoder.class);
    MAP_DECODERS.put(UnreservedTemplate.class, UnreservedTemplateDecoder.class);
    MAP_DECODERS.put(Unreserved.class, UnreservedDecoder.class);
    MAP_DECODERS.put(PaymentSystemSpecificTemplate.class, PaymentSystemSpecificTemplateDecoder.class);
    MAP_DECODERS.put(PaymentSystemSpecific.class, PaymentSystemSpecificDecoder.class);
  }

  private DecodersMpmMap() {
    super();
  }

  public static Class<? extends DecoderMpm<?>> getDecoder(final Class<?> clazz) {
    return MAP_DECODERS.get(clazz);
  }

}
