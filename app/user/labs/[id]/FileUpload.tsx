import React from "react"
import { Button } from "@/components/ui/button"

interface FileUploadProps {
  accept?: string
  onChange: (files: FileList | null) => void
}

export function FileUpload({ accept, onChange }: FileUploadProps) {
  const fileInputRef = React.useRef<HTMLInputElement>(null)

  const handleClick = () => {
    fileInputRef.current?.click()
  }

  return (
    <div className="flex items-center space-x-2">
      <input
        type="file"
        className="hidden"
        ref={fileInputRef}
        accept={accept}
        onChange={(e) => onChange(e.target.files)}
      />
      <Button type="button" onClick={handleClick}>
        Choose File
      </Button>
      <span className="text-sm text-gray-500">{fileInputRef.current?.files?.[0]?.name || "No file chosen"}</span>
    </div>
  )
}

