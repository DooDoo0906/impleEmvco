package decoder.mpm;


import core.exception.PresentedModeException;
import core.utils.TLVUtils;
import model.mpm.MerchantAccountInformationReserved;

// @formatter:off
public final class MerchantAccountInformationReservedDecoder extends DecoderMpm<MerchantAccountInformationReserved> {

  public MerchantAccountInformationReservedDecoder(final String source) {
    super(source);
  }

  @Override
  protected MerchantAccountInformationReserved decode() throws PresentedModeException {
    final String value = iterator.next();
    return new MerchantAccountInformationReserved(TLVUtils.valueOf(value));
  }

}
// @formatter:on
