package org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject;

import java.util.UUID;

/**
 * NationalProviderIdentifier value object
 * <p>
 *     This class represents a NationalProviderIdentifier value object.
 * </p>
 * @param nationalProviderIdentifier
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
public record NationalProviderIdentifier(String nationalProviderIdentifier) {
    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isBlank()){
            throw new IllegalArgumentException("National Provider Identifier cannot be null");
        }

        try{
            UUID.fromString(nationalProviderIdentifier);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("National Provider Identifier must be a valid UUID");
        }
    }
}
