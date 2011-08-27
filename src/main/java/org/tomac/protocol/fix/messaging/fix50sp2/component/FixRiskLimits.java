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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRiskInstrumentScope;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRiskWarningLevels;

public class FixRiskLimits
{

	public int noRiskLimits;
	public RiskLimits[] group;

	public void getAll(int noRiskLimits, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRiskLimits = noRiskLimits;

		if (noRiskLimits < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRiskLimits ).getBytes(), FixTags.NORISKLIMITS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRiskLimits) {
			group = new RiskLimits[noRiskLimits];

			for ( int i = 0; i < noRiskLimits; i++ ) group[i] = new RiskLimits();
	}

		for ( int i = 0; i < noRiskLimits; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRiskLimits; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRiskLimits; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRiskLimits; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRiskLimits)) return false;

		FixRiskLimits msg = (FixRiskLimits) o;

		for (int i = 0; i<noRiskLimits; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRiskLimits; i++)
			s += group[i].toString();
		return s;
	}

public class RiskLimits implements FixComponent
{

	public long riskLimitType = 0;
	public long riskLimitAmount = 0;
	public byte[] riskLimitCurrency;
	public byte[] riskLimitPlatform;
	public FixRiskInstrumentScope riskInstrumentScope;
	public FixRiskWarningLevels riskWarningLevels;

	public RiskLimits() {
		super();

		riskLimitCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		riskLimitPlatform = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskInstrumentScope = new FixRiskInstrumentScope();
		riskWarningLevels = new FixRiskWarningLevels();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		riskLimitType = Long.MAX_VALUE;		
		riskLimitAmount = Long.MAX_VALUE;		
		Utils.fill( riskLimitCurrency, (byte)0 );
		Utils.fill( riskLimitPlatform, (byte)0 );
		riskInstrumentScope.clear();
		riskWarningLevels.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RISKLIMITTYPE_INT) {
				riskLimitType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.RiskLimitType.isValid(riskLimitType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + riskLimitType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKLIMITAMOUNT_INT) {
				riskLimitAmount = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKLIMITCURRENCY_INT) {
				riskLimitCurrency = FixUtils.getTagStringValue(value, riskLimitCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKLIMITPLATFORM_INT) {
				riskLimitPlatform = FixUtils.getTagStringValue(value, riskLimitPlatform);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORISKINSTRUMENTS_INT) {
				int noRiskInstruments;
				noRiskInstruments = FixUtils.getTagIntValue( value );
				riskInstrumentScope.getAll(noRiskInstruments, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORISKWARNINGLEVELS_INT) {
				int noRiskWarningLevels;
				noRiskWarningLevels = FixUtils.getTagIntValue( value );
				riskWarningLevels.getAll(noRiskWarningLevels, buf);
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
		if (FixUtils.isSet(riskLimitType)) return true;
		if (FixUtils.isSet(riskLimitAmount)) return true;
		if (FixUtils.isSet(riskLimitCurrency)) return true;
		if (FixUtils.isSet(riskLimitPlatform)) return true;
		if (FixUtils.isSet(riskInstrumentScope.noRiskInstruments)) return true;
		if (FixUtils.isSet(riskWarningLevels.noRiskWarningLevels)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(riskLimitType)) FixUtils.putFixTag( out, FixTags.RISKLIMITTYPE_INT, riskLimitType);
		if (FixUtils.isSet(riskLimitAmount)) FixUtils.putFixTag( out, FixTags.RISKLIMITAMOUNT_INT, riskLimitAmount);
		if (FixUtils.isSet(riskLimitCurrency)) FixUtils.putFixTag( out, FixTags.RISKLIMITCURRENCY_INT, riskLimitCurrency, 0, Utils.lastIndexTrim(riskLimitCurrency, (byte)0) );
		if (FixUtils.isSet(riskLimitPlatform)) FixUtils.putFixTag( out, FixTags.RISKLIMITPLATFORM_INT, riskLimitPlatform, 0, Utils.lastIndexTrim(riskLimitPlatform, (byte)0) );
		if (FixUtils.isSet(riskInstrumentScope.noRiskInstruments)) riskInstrumentScope.encode( out );
		if (FixUtils.isSet(riskWarningLevels.noRiskWarningLevels)) riskWarningLevels.encode( out );
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

			if (FixUtils.isSet(riskLimitType)) s += "RiskLimitType(1530)=" + String.valueOf(riskLimitType) + sep;
			if (FixUtils.isSet(riskLimitAmount)) s += "RiskLimitAmount(1531)=" + String.valueOf(riskLimitAmount) + sep;
			if (FixUtils.isSet(riskLimitCurrency)) s += "RiskLimitCurrency(1532)=" + new String(riskLimitCurrency) + sep;
			if (FixUtils.isSet(riskLimitPlatform)) s += "RiskLimitPlatform(1533)=" + new String(riskLimitPlatform) + sep;
			if (FixUtils.isSet(riskInstrumentScope.noRiskInstruments)) s += riskInstrumentScope.toString();
			if (FixUtils.isSet(riskWarningLevels.noRiskWarningLevels)) s += riskWarningLevels.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RiskLimits)) return false;

			RiskLimits msg = (RiskLimits) o;

		if (!( riskLimitType==msg.riskLimitType)) return false;

		if (!( riskLimitAmount==msg.riskLimitAmount)) return false;

		if (!Utils.equals( riskLimitCurrency, msg.riskLimitCurrency)) return false;

		if (!Utils.equals( riskLimitPlatform, msg.riskLimitPlatform)) return false;

		if (!riskInstrumentScope.equals(msg.riskInstrumentScope)) return false;

		if (!riskWarningLevels.equals(msg.riskWarningLevels)) return false;

		return true;
	}
}
}
