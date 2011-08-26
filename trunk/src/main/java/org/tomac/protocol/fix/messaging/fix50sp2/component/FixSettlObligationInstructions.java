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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSettlDetails;

public class FixSettlObligationInstructions
{

	public int noSettlOblig;
	public SettlObligationInstructions[] group;

	public void getAll(int noSettlOblig, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noSettlOblig = noSettlOblig;

		if (noSettlOblig < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noSettlOblig ).getBytes(), FixTags.NOSETTLOBLIG_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noSettlOblig) {
			group = new SettlObligationInstructions[noSettlOblig];

			for ( int i = 0; i < noSettlOblig; i++ ) group[i] = new SettlObligationInstructions();
	}

		for ( int i = 0; i < noSettlOblig; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noSettlOblig; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noSettlOblig; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noSettlOblig; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noSettlOblig; i++)
			s += group[i].toString();
		return s;
	}

public class SettlObligationInstructions implements FixComponent
{

	public long netGrossInd = 0;
	public byte[] settlObligID;
	public byte settlObligTransType = (byte)' ';
	public byte[] settlObligRefID;
	public long ccyAmt = 0;
	public long settlCurrAmt = 0;
	public byte[] currency;
	public byte[] settlCurrency;
	public long settlCurrFxRate = 0;
	public byte[] settlDate;
	public byte[] effectiveTime;
	public byte[] expireTime;
	public byte[] lastUpdateTime;
	public FixInstrument instrument;
	public FixParties parties;
	public FixSettlDetails settlDetails;

	public SettlObligationInstructions() {
		super();

		settlObligID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlObligRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		instrument = new FixInstrument();
		parties = new FixParties();
		settlDetails = new FixSettlDetails();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		netGrossInd = Long.MAX_VALUE;		
		Utils.fill( settlObligID, (byte)0 );
		settlObligTransType = Byte.MAX_VALUE;		
		Utils.fill( settlObligRefID, (byte)0 );
		ccyAmt = Long.MAX_VALUE;		
		settlCurrAmt = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		Utils.fill( settlCurrency, (byte)0 );
		settlCurrFxRate = Long.MAX_VALUE;		
		Utils.fill( settlDate, (byte)0 );
		Utils.fill( effectiveTime, (byte)0 );
		Utils.fill( expireTime, (byte)0 );
		Utils.fill( lastUpdateTime, (byte)0 );
		instrument.clear();
		parties.clear();
		settlDetails.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NETGROSSIND_INT) {
				netGrossInd = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.NetGrossInd.isValid(netGrossInd) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + netGrossInd + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLOBLIGID_INT) {
				settlObligID = FixUtils.getTagStringValue(value, settlObligID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLOBLIGTRANSTYPE_INT) {
				settlObligTransType = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.SettlObligTransType.isValid(settlObligTransType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + settlObligTransType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLOBLIGREFID_INT) {
				settlObligRefID = FixUtils.getTagStringValue(value, settlObligRefID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CCYAMT_INT) {
				ccyAmt = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLCURRAMT_INT) {
				settlCurrAmt = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CURRENCY_INT) {
				currency = FixUtils.getTagStringValue(value, currency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLCURRENCY_INT) {
				settlCurrency = FixUtils.getTagStringValue(value, settlCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLCURRFXRATE_INT) {
				settlCurrFxRate = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLDATE_INT) {
				settlDate = FixUtils.getTagStringValue(value, settlDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.EFFECTIVETIME_INT) {
				effectiveTime = FixUtils.getTagStringValue(value, effectiveTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.EXPIRETIME_INT) {
				expireTime = FixUtils.getTagStringValue(value, expireTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LASTUPDATETIME_INT) {
				lastUpdateTime = FixUtils.getTagStringValue(value, lastUpdateTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOPARTYIDS_INT) {
				parties.getAll(FixTags.NOPARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOSETTLDETAILS_INT) {
				settlDetails.getAll(FixTags.NOSETTLDETAILS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(netGrossInd)) return true;
		if (FixUtils.isSet(settlObligID)) return true;
		if (FixUtils.isSet(settlObligTransType)) return true;
		if (FixUtils.isSet(settlObligRefID)) return true;
		if (FixUtils.isSet(ccyAmt)) return true;
		if (FixUtils.isSet(settlCurrAmt)) return true;
		if (FixUtils.isSet(currency)) return true;
		if (FixUtils.isSet(settlCurrency)) return true;
		if (FixUtils.isSet(settlCurrFxRate)) return true;
		if (FixUtils.isSet(settlDate)) return true;
		if (FixUtils.isSet(effectiveTime)) return true;
		if (FixUtils.isSet(expireTime)) return true;
		if (FixUtils.isSet(lastUpdateTime)) return true;
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(parties.noPartyIDs)) return true;
		if (FixUtils.isSet(settlDetails.noSettlDetails)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(netGrossInd)) FixUtils.putFixTag( out, FixTags.NETGROSSIND_INT, netGrossInd);
		if (FixUtils.isSet(settlObligID)) FixUtils.putFixTag( out, FixTags.SETTLOBLIGID_INT, settlObligID, 0, Utils.lastIndexTrim(settlObligID, (byte)0) );
		if (FixUtils.isSet(settlObligTransType)) FixUtils.putFixTag( out, FixTags.SETTLOBLIGTRANSTYPE_INT, settlObligTransType );
		if (FixUtils.isSet(settlObligRefID)) FixUtils.putFixTag( out, FixTags.SETTLOBLIGREFID_INT, settlObligRefID, 0, Utils.lastIndexTrim(settlObligRefID, (byte)0) );
		if (FixUtils.isSet(ccyAmt)) FixUtils.putFixTag( out, FixTags.CCYAMT_INT, ccyAmt);
		if (FixUtils.isSet(settlCurrAmt)) FixUtils.putFixTag( out, FixTags.SETTLCURRAMT_INT, settlCurrAmt);
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(settlCurrency)) FixUtils.putFixTag( out, FixTags.SETTLCURRENCY_INT, settlCurrency, 0, Utils.lastIndexTrim(settlCurrency, (byte)0) );
		if (FixUtils.isSet(settlCurrFxRate)) FixUtils.putFixFloatTag( out, FixTags.SETTLCURRFXRATE_INT, settlCurrFxRate);
		if (FixUtils.isSet(settlDate)) FixUtils.putFixTag( out, FixTags.SETTLDATE_INT, settlDate);
		if (FixUtils.isSet(effectiveTime)) FixUtils.putFixTag( out, FixTags.EFFECTIVETIME_INT, effectiveTime);
		if (FixUtils.isSet(expireTime)) FixUtils.putFixTag( out, FixTags.EXPIRETIME_INT, expireTime);
		if (FixUtils.isSet(lastUpdateTime)) FixUtils.putFixTag( out, FixTags.LASTUPDATETIME_INT, lastUpdateTime);
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(settlDetails.noSettlDetails)) settlDetails.encode( out );
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

			if (FixUtils.isSet(netGrossInd)) s += "NetGrossInd(430)=" + String.valueOf(netGrossInd) + sep;
			if (FixUtils.isSet(settlObligID)) s += "SettlObligID(1161)=" + new String(settlObligID) + sep;
			if (FixUtils.isSet(settlObligTransType)) s += "SettlObligTransType(1162)=" + String.valueOf(settlObligTransType) + sep;
			if (FixUtils.isSet(settlObligRefID)) s += "SettlObligRefID(1163)=" + new String(settlObligRefID) + sep;
			if (FixUtils.isSet(ccyAmt)) s += "CcyAmt(1157)=" + String.valueOf(ccyAmt) + sep;
			if (FixUtils.isSet(settlCurrAmt)) s += "SettlCurrAmt(119)=" + String.valueOf(settlCurrAmt) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(settlCurrency)) s += "SettlCurrency(120)=" + new String(settlCurrency) + sep;
			if (FixUtils.isSet(settlCurrFxRate)) s += "SettlCurrFxRate(155)=" + String.valueOf(settlCurrFxRate) + sep;
			if (FixUtils.isSet(settlDate)) s += "SettlDate(64)=" + new String(settlDate) + sep;
			if (FixUtils.isSet(effectiveTime)) s += "EffectiveTime(168)=" + new String(effectiveTime) + sep;
			if (FixUtils.isSet(expireTime)) s += "ExpireTime(126)=" + new String(expireTime) + sep;
			if (FixUtils.isSet(lastUpdateTime)) s += "LastUpdateTime(779)=" + new String(lastUpdateTime) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(settlDetails.noSettlDetails)) s += settlDetails.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SettlObligationInstructions)) return false;

			SettlObligationInstructions msg = (SettlObligationInstructions) o;

		if ( ! super.equals(msg) ) return false;

		if (!( netGrossInd==msg.netGrossInd)) return false;

		if (!Utils.equals( settlObligID, msg.settlObligID)) return false;

		if (!( settlObligTransType==msg.settlObligTransType)) return false;

		if (!Utils.equals( settlObligRefID, msg.settlObligRefID)) return false;

		if (!( ccyAmt==msg.ccyAmt)) return false;

		if (!( settlCurrAmt==msg.settlCurrAmt)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( settlCurrency, msg.settlCurrency)) return false;

		if (!( settlCurrFxRate==msg.settlCurrFxRate)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!settlDetails.equals(msg.settlDetails)) return false;

		return true;
	}
}
}
