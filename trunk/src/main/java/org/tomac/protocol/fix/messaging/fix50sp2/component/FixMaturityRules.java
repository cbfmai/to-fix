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

public class FixMaturityRules
{

	public int noMaturityRules;
	public MaturityRules[] group;

	public void getAll(int noMaturityRules, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noMaturityRules = noMaturityRules;

		if (noMaturityRules < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noMaturityRules ).getBytes(), FixTags.NOMATURITYRULES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noMaturityRules) {
			group = new MaturityRules[noMaturityRules];

			for ( int i = 0; i < noMaturityRules; i++ ) group[i] = new MaturityRules();
	}

		for ( int i = 0; i < noMaturityRules; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noMaturityRules; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noMaturityRules; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noMaturityRules; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noMaturityRules; i++)
			s += group[i].toString();
		return s;
	}

public class MaturityRules implements FixComponent
{

	public byte[] maturityRuleID;
	public long maturityMonthYearFormat = 0;
	public long maturityMonthYearIncrementUnits = 0;
	public byte[] startMaturityMonthYear;
	public byte[] endMaturityMonthYear;
	public long maturityMonthYearIncrement = 0;

	public MaturityRules() {
		super();

		maturityRuleID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		startMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		endMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( maturityRuleID, (byte)0 );
		maturityMonthYearFormat = Long.MAX_VALUE;		
		maturityMonthYearIncrementUnits = Long.MAX_VALUE;		
		Utils.fill( startMaturityMonthYear, (byte)0 );
		Utils.fill( endMaturityMonthYear, (byte)0 );
		maturityMonthYearIncrement = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.MATURITYRULEID_INT) {
				maturityRuleID = FixUtils.getTagStringValue(value, maturityRuleID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MATURITYMONTHYEARFORMAT_INT) {
				maturityMonthYearFormat = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.MaturityMonthYearFormat.isValid(maturityMonthYearFormat) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + maturityMonthYearFormat + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MATURITYMONTHYEARINCREMENTUNITS_INT) {
				maturityMonthYearIncrementUnits = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.MaturityMonthYearIncrementUnits.isValid(maturityMonthYearIncrementUnits) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + maturityMonthYearIncrementUnits + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.STARTMATURITYMONTHYEAR_INT) {
				startMaturityMonthYear = FixUtils.getTagStringValue(value, startMaturityMonthYear);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENDMATURITYMONTHYEAR_INT) {
				endMaturityMonthYear = FixUtils.getTagStringValue(value, endMaturityMonthYear);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MATURITYMONTHYEARINCREMENT_INT) {
				maturityMonthYearIncrement = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(maturityRuleID)) return true;
		if (FixUtils.isSet(maturityMonthYearFormat)) return true;
		if (FixUtils.isSet(maturityMonthYearIncrementUnits)) return true;
		if (FixUtils.isSet(startMaturityMonthYear)) return true;
		if (FixUtils.isSet(endMaturityMonthYear)) return true;
		if (FixUtils.isSet(maturityMonthYearIncrement)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(maturityRuleID)) FixUtils.putFixTag( out, FixTags.MATURITYRULEID_INT, maturityRuleID, 0, Utils.lastIndexTrim(maturityRuleID, (byte)0) );
		if (FixUtils.isSet(maturityMonthYearFormat)) FixUtils.putFixTag( out, FixTags.MATURITYMONTHYEARFORMAT_INT, maturityMonthYearFormat);
		if (FixUtils.isSet(maturityMonthYearIncrementUnits)) FixUtils.putFixTag( out, FixTags.MATURITYMONTHYEARINCREMENTUNITS_INT, maturityMonthYearIncrementUnits);
		if (FixUtils.isSet(startMaturityMonthYear)) FixUtils.putFixTag( out, FixTags.STARTMATURITYMONTHYEAR_INT, startMaturityMonthYear);
		if (FixUtils.isSet(endMaturityMonthYear)) FixUtils.putFixTag( out, FixTags.ENDMATURITYMONTHYEAR_INT, endMaturityMonthYear);
		if (FixUtils.isSet(maturityMonthYearIncrement)) FixUtils.putFixTag( out, FixTags.MATURITYMONTHYEARINCREMENT_INT, maturityMonthYearIncrement);
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

			if (FixUtils.isSet(maturityRuleID)) s += "MaturityRuleID(1222)=" + new String(maturityRuleID) + sep;
			if (FixUtils.isSet(maturityMonthYearFormat)) s += "MaturityMonthYearFormat(1303)=" + String.valueOf(maturityMonthYearFormat) + sep;
			if (FixUtils.isSet(maturityMonthYearIncrementUnits)) s += "MaturityMonthYearIncrementUnits(1302)=" + String.valueOf(maturityMonthYearIncrementUnits) + sep;
			if (FixUtils.isSet(startMaturityMonthYear)) s += "StartMaturityMonthYear(1241)=" + new String(startMaturityMonthYear) + sep;
			if (FixUtils.isSet(endMaturityMonthYear)) s += "EndMaturityMonthYear(1226)=" + new String(endMaturityMonthYear) + sep;
			if (FixUtils.isSet(maturityMonthYearIncrement)) s += "MaturityMonthYearIncrement(1229)=" + String.valueOf(maturityMonthYearIncrement) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof MaturityRules)) return false;

			MaturityRules msg = (MaturityRules) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( maturityRuleID, msg.maturityRuleID)) return false;

		if (!( maturityMonthYearFormat==msg.maturityMonthYearFormat)) return false;

		if (!( maturityMonthYearIncrementUnits==msg.maturityMonthYearIncrementUnits)) return false;

		if (!Utils.equals( startMaturityMonthYear, msg.startMaturityMonthYear)) return false;

		if (!Utils.equals( endMaturityMonthYear, msg.endMaturityMonthYear)) return false;

		if (!( maturityMonthYearIncrement==msg.maturityMonthYearIncrement)) return false;

		return true;
	}
}
}
