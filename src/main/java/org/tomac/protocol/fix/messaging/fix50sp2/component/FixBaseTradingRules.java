package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTickRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLotTypeRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPriceLimits;

public class FixBaseTradingRules implements FixComponent
{

	public long expirationCycle = 0;
	public long minTradeVol = 0;
	public long maxTradeVol = 0;
	public long maxPriceVariation = 0;
	public long impliedMarketIndicator = 0;
	public byte[] tradingCurrency;
	public FixTickRules tickRules;
	public FixLotTypeRules lotTypeRules;
	public FixPriceLimits priceLimits;
	public long roundLot = 0;
	public long multilegModel = 0;
	public long multilegPriceMethod = 0;
	public long priceType = 0;

	public FixBaseTradingRules() {
		super();

		tradingCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		tickRules = new FixTickRules();
		lotTypeRules = new FixLotTypeRules();
		priceLimits = new FixPriceLimits();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		expirationCycle = Long.MAX_VALUE;		
		minTradeVol = Long.MAX_VALUE;		
		maxTradeVol = Long.MAX_VALUE;		
		maxPriceVariation = Long.MAX_VALUE;		
		impliedMarketIndicator = Long.MAX_VALUE;		
		Utils.fill( tradingCurrency, (byte)0 );
		roundLot = Long.MAX_VALUE;		
		multilegModel = Long.MAX_VALUE;		
		multilegPriceMethod = Long.MAX_VALUE;		
		priceType = Long.MAX_VALUE;		
		tickRules.clear();
		lotTypeRules.clear();
		priceLimits.clear();
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.EXPIRATIONCYCLE_INT:
				expirationCycle = FixUtils.getTagIntValue( value );
				if (!ExpirationCycle.isValid(expirationCycle) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + expirationCycle + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.MINTRADEVOL_INT:
				minTradeVol = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.MAXTRADEVOL_INT:
				maxTradeVol = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.MAXPRICEVARIATION_INT:
				maxPriceVariation = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.IMPLIEDMARKETINDICATOR_INT:
				impliedMarketIndicator = FixUtils.getTagIntValue( value );
				if (!ImpliedMarketIndicator.isValid(impliedMarketIndicator) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + impliedMarketIndicator + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.TRADINGCURRENCY_INT:
				tradingCurrency = FixUtils.getTagStringValue(value, tradingCurrency);
				break;

			case FixTags.NOTICKRULES_INT:
				tickRules.noTickRules = FixUtils.getTagIntValue( value );
				tickRules.getAll(tickRules.noTickRules, value );
				break;

			case FixTags.NOLOTTYPERULES_INT:
				lotTypeRules.noLotTypeRules = FixUtils.getTagIntValue( value );
				lotTypeRules.getAll(lotTypeRules.noLotTypeRules, value );
				break;

			case FixTags.PRICELIMITTYPE_INT:
				priceLimits.getAll( FixTags.PRICELIMITTYPE_INT, value );
				break;

			case FixTags.ROUNDLOT_INT:
				roundLot = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.MULTILEGMODEL_INT:
				multilegModel = FixUtils.getTagIntValue( value );
				if (!MultilegModel.isValid(multilegModel) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + multilegModel + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.MULTILEGPRICEMETHOD_INT:
				multilegPriceMethod = FixUtils.getTagIntValue( value );
				if (!MultilegPriceMethod.isValid(multilegPriceMethod) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + multilegPriceMethod + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.PRICETYPE_INT:
				priceType = FixUtils.getTagIntValue( value );
				if (!PriceType.isValid(priceType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + priceType + ") for tag").getBytes(), id, new byte[0] );
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) > 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(expirationCycle)) return true;
		if (FixUtils.isSet(minTradeVol)) return true;
		if (FixUtils.isSet(maxTradeVol)) return true;
		if (FixUtils.isSet(maxPriceVariation)) return true;
		if (FixUtils.isSet(impliedMarketIndicator)) return true;
		if (FixUtils.isSet(tradingCurrency)) return true;
		if (FixUtils.isSet(tickRules.noTickRules)) return true;
		if (FixUtils.isSet(lotTypeRules.noLotTypeRules)) return true;
		if (FixUtils.isSet(priceLimits.priceLimitType)) return true;
		if (FixUtils.isSet(roundLot)) return true;
		if (FixUtils.isSet(multilegModel)) return true;
		if (FixUtils.isSet(multilegPriceMethod)) return true;
		if (FixUtils.isSet(priceType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(expirationCycle)) FixUtils.putFixTag( out, FixTags.EXPIRATIONCYCLE_INT, expirationCycle);
		if (FixUtils.isSet(minTradeVol)) FixUtils.putFixFloatTag( out, FixTags.MINTRADEVOL_INT, minTradeVol);
		if (FixUtils.isSet(maxTradeVol)) FixUtils.putFixFloatTag( out, FixTags.MAXTRADEVOL_INT, maxTradeVol);
		if (FixUtils.isSet(maxPriceVariation)) FixUtils.putFixFloatTag( out, FixTags.MAXPRICEVARIATION_INT, maxPriceVariation);
		if (FixUtils.isSet(impliedMarketIndicator)) FixUtils.putFixTag( out, FixTags.IMPLIEDMARKETINDICATOR_INT, impliedMarketIndicator);
		if (FixUtils.isSet(tradingCurrency)) FixUtils.putFixTag( out, FixTags.TRADINGCURRENCY_INT, tradingCurrency, 0, Utils.lastIndexTrim(tradingCurrency, (byte)0) );
		if (FixUtils.isSet(tickRules.noTickRules)) tickRules.encode( out );
		if (FixUtils.isSet(lotTypeRules.noLotTypeRules)) lotTypeRules.encode( out );
		if (FixUtils.isSet(priceLimits.priceLimitType)) priceLimits.encode( out );
		if (FixUtils.isSet(roundLot)) FixUtils.putFixFloatTag( out, FixTags.ROUNDLOT_INT, roundLot);
		if (FixUtils.isSet(multilegModel)) FixUtils.putFixTag( out, FixTags.MULTILEGMODEL_INT, multilegModel);
		if (FixUtils.isSet(multilegPriceMethod)) FixUtils.putFixTag( out, FixTags.MULTILEGPRICEMETHOD_INT, multilegPriceMethod);
		if (FixUtils.isSet(priceType)) FixUtils.putFixTag( out, FixTags.PRICETYPE_INT, priceType);
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(expirationCycle)) s += "ExpirationCycle(827)=" + String.valueOf(expirationCycle) + sep;
			if (FixUtils.isSet(minTradeVol)) s += "MinTradeVol(562)=" + String.valueOf(minTradeVol) + sep;
			if (FixUtils.isSet(maxTradeVol)) s += "MaxTradeVol(1140)=" + String.valueOf(maxTradeVol) + sep;
			if (FixUtils.isSet(maxPriceVariation)) s += "MaxPriceVariation(1143)=" + String.valueOf(maxPriceVariation) + sep;
			if (FixUtils.isSet(impliedMarketIndicator)) s += "ImpliedMarketIndicator(1144)=" + String.valueOf(impliedMarketIndicator) + sep;
			if (FixUtils.isSet(tradingCurrency)) s += "TradingCurrency(1245)=" + new String(tradingCurrency) + sep;
			if (FixUtils.isSet(tickRules.noTickRules)) s += tickRules.toString();
			if (FixUtils.isSet(lotTypeRules.noLotTypeRules)) s += lotTypeRules.toString();
			if (FixUtils.isSet(priceLimits.priceLimitType)) s += priceLimits.toString();
			if (FixUtils.isSet(roundLot)) s += "RoundLot(561)=" + String.valueOf(roundLot) + sep;
			if (FixUtils.isSet(multilegModel)) s += "MultilegModel(1377)=" + String.valueOf(multilegModel) + sep;
			if (FixUtils.isSet(multilegPriceMethod)) s += "MultilegPriceMethod(1378)=" + String.valueOf(multilegPriceMethod) + sep;
			if (FixUtils.isSet(priceType)) s += "PriceType(423)=" + String.valueOf(priceType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBaseTradingRules)) return false;

			FixBaseTradingRules msg = (FixBaseTradingRules) o;

		if (!( expirationCycle==msg.expirationCycle)) return false;

		if (!( minTradeVol==msg.minTradeVol)) return false;

		if (!( maxTradeVol==msg.maxTradeVol)) return false;

		if (!( maxPriceVariation==msg.maxPriceVariation)) return false;

		if (!( impliedMarketIndicator==msg.impliedMarketIndicator)) return false;

		if (!Utils.equals( tradingCurrency, msg.tradingCurrency)) return false;

		if (!tickRules.equals(msg.tickRules)) return false;

		if (!lotTypeRules.equals(msg.lotTypeRules)) return false;

		if (!priceLimits.equals(msg.priceLimits)) return false;

		if (!( roundLot==msg.roundLot)) return false;

		if (!( multilegModel==msg.multilegModel)) return false;

		if (!( multilegPriceMethod==msg.multilegPriceMethod)) return false;

		if (!( priceType==msg.priceType)) return false;

		return true;
	}
}
