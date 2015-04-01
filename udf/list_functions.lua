-- TAKES
--   record  --  the record
--   binname --  the bin name to be used
function remove_first_item(record, binname, value)
    if (not aerospike:exists(record) or record[binname] == nil) then
        return nil
    end

    local count = list_count(record[binname])
    if (count > 0) then
        local retVal = record[binname][1] -- lua is 1 based

        if (count > 1) then
            list.remove(record[binname], 1) -- lua is 1 based
            record[binname] = record[binname]
            aerospike:update(record)
        else
            aerospike:remove(record)
        end

        return retVal
    end

    return nil
end
