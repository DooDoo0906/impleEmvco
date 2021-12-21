package decoder.mpm;


import core.exception.PresentedModeException;
import core.utils.TLVUtils;
import model.mpm.PaymentSystemSpecific;
import model.mpm.PaymentSystemSpecificTemplate;

// @formatter:off
public final class PaymentSystemSpecificTemplateDecoder extends DecoderMpm<PaymentSystemSpecificTemplate> {

  public PaymentSystemSpecificTemplateDecoder(final String source) {
    super(source);
  }

  @Override
  protected PaymentSystemSpecificTemplate decode() throws PresentedModeException {
    final PaymentSystemSpecificTemplate result = new PaymentSystemSpecificTemplate();

    while(iterator.hasNext()) {
      final String value = iterator.next();
      result.setTag(TLVUtils.valueOfTag(value));
      result.setValue(DecoderMpm.decode(value, PaymentSystemSpecific.class));
    }

    return result;
  }

}
// @formatter:on
