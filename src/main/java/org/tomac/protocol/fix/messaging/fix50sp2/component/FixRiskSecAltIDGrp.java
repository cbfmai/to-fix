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

public class FixRiskSecAltIDGrp
{

	public int noRiskSecurityAltID;
	public RiskSecAltIDGrp[] group;

	public void getAll(int noRiskSecurityAltID, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRiskSecurityAltID = noRiskSecurityAltID;

		if (noRiskSecurityAltID < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRiskSecurityAltID ).getBytes(), FixTags.NORISKSECURITYALTID_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRiskSecurityAltID) {
			group = new RiskSecAltIDGrp[noRiskSecurityAltID];

			for ( int i = 0; i < noRiskSecurityAltID; i++ ) group[i] = new RiskSecAltIDGrp();
	}

		for ( int i = 0; i < noRiskSecurityAltID; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRiskSecurityAltID; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRiskSecurityAltID; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRiskSecurityAltID; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRiskSecAltIDGrp)) return false;

		FixRiskSecAltIDGrp msg = (FixRiskSecAltIDGrp) o;

		for (int i = 0; i<noRiskSecurityAltID; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRiskSecurityAltID; i++)
			s += group[i].toString();
		return s;
	}

public class RiskSecAltIDGrp implements FixComponent
{

	public long noRiskSecurityAltID = 0;
	public byte[] riskSecurityAltID;
	public byte[] riskSecurityAltIDSource;

	public RiskSecAltIDGrp() {
		super();

		riskSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		noRiskSecurityAltID = Long.MAX_VALUE;		
		Utils.fill( riskSecurityAltID, (byte)0 );
		Utils.fill( riskSecurityAltIDSource, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NORISKSECURITYALTID_INT) {
				noRiskSecurityAltID = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYALTID_INT) {
				riskSecurityAltID = FixUtils.getTagStringValue(null ,id ,value, riskSecurityAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYALTIDSOURCE_INT) {
				riskSecurityAltIDSource = FixUtils.getTagStringValue(null ,id ,value, riskSecurityAltIDSource);
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
		if (FixUtils.isSet(noRiskSecurityAltID)) return true;
		if (FixUtils.isSet(riskSecurityAltID)) return true;
		if (FixUtils.isSet(riskSecurityAltIDSource)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(noRiskSecurityAltID)) FixUtils.putFixTag( out, FixTags.NORISKSECURITYALTID_INT, noRiskSecurityAltID);
		if (FixUtils.isSet(riskSecurityAltID)) FixUtils.putFixTag( out, FixTags.RISKSECURITYALTID_INT, riskSecurityAltID, 0, Utils.lastIndexTrim(riskSecurityAltID, (byte)0) );
		if (FixUtils.isSet(riskSecurityAltIDSource)) FixUtils.putFixTag( out, FixTags.RISKSECURITYALTIDSOURCE_INT, riskSecurityAltIDSource, 0, Utils.lastIndexTrim(riskSecurityAltIDSource, (byte)0) );
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

			if (FixUtils.isSet(noRiskSecurityAltID)) s += "NoRiskSecurityAltID(1540)=" + String.valueOf(noRiskSecurityAltID) + sep;
			if (FixUtils.isSet(riskSecurityAltID)) s += "RiskSecurityAltID(1541)=" + new String(riskSecurityAltID) + sep;
			if (FixUtils.isSet(riskSecurityAltIDSource)) s += "RiskSecurityAltIDSource(1542)=" + new String(riskSecurityAltIDSource) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RiskSecAltIDGrp)) return false;

			RiskSecAltIDGrp msg = (RiskSecAltIDGrp) o;

		if (!( noRiskSecurityAltID==msg.noRiskSecurityAltID)) return false;

		if (!Utils.equals( riskSecurityAltID, msg.riskSecurityAltID)) return false;

		if (!Utils.equals( riskSecurityAltIDSource, msg.riskSecurityAltIDSource)) return false;

		return true;
	}
}
}
