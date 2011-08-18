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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixPartyListResponseTypeGrp
{

	public int noPartyListResponseTypes;
	public PartyListResponseTypeGrp[] group;

	public void getAll(int noPartyListResponseTypes, ByteBuffer buf) throws FixSessionException {
		this.noPartyListResponseTypes = noPartyListResponseTypes;

		if (noPartyListResponseTypes < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noPartyListResponseTypes) 
			group = new PartyListResponseTypeGrp[noPartyListResponseTypes];

		for ( int i = 0; i < noPartyListResponseTypes; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noPartyListResponseTypes; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noPartyListResponseTypes; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noPartyListResponseTypes; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noPartyListResponseTypes; i++)
			s += group[i].toString();
		return s;
	}

public class PartyListResponseTypeGrp implements FixComponent
{

	public long partyListResponseType = 0;

	public PartyListResponseTypeGrp() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		partyListResponseType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.PARTYLISTRESPONSETYPE_INT) {
				partyListResponseType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.PartyListResponseType.isValid(partyListResponseType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + partyListResponseType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(partyListResponseType) ) return FixTags.PARTYLISTRESPONSETYPE_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.PARTYLISTRESPONSETYPE_INT, partyListResponseType);
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

			 s += "PartyListResponseType(1507)=" + String.valueOf(partyListResponseType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof PartyListResponseTypeGrp)) return false;

			PartyListResponseTypeGrp msg = (PartyListResponseTypeGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( partyListResponseType==msg.partyListResponseType)) return false;

		return true;
	}
}
}
